package com.connector.sat.service;

import com.connector.sat.dao.SATResponseDAO;
import com.connector.sat.repository.CSVWriter;
import com.connector.sat.model.CfeConsultarLotesResponse;
import com.connector.sat.model.ResLote;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/sat")
@ApplicationPath("/connector")
public class SATService extends Application {
    @GET
    @Path("/test-connectivity")
    @Produces("text/plain")
    public String testConnectivity() {
        return "The server is up and running!";
    }

    @POST
    @Path("/query")
    @Consumes(MediaType.APPLICATION_JSON)
    public String sendRequest(SATRequest satRequest) throws Exception {
        String url = "https://wssatsp.fazenda.sp.gov.br/CfeConsultarLotes/CfeConsultarLotes.asmx";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .timeout(Duration.ofSeconds(600))
                .POST(HttpRequest.BodyPublishers.ofString(SOAPBuilder.buildSATRequest(satRequest)))
                .header("Content-Type", "text/xml")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        CfeConsultarLotesResponse responseObject = SATResponse.unmarshal(response.body());
        ResLote resLote = responseObject.getCfeConsultarLotesResult().getResLote();

        if ( Objects.equals(PropertiesLoader.loadProperties("useDatabase"), "true") && Objects.nonNull(resLote.getLote()) ) {
            List<Cupom> cupomList = new ArrayList<>();
            cupomList.add(new Cupom(
                    resLote.getLote().getNRec(),
                    resLote.getLote().getInfCfe().getCfe().getChave(),
                    Integer.getInteger(resLote.getLote().getInfCfe().getCfe().getNCupom()),
                    resLote.getLote().getInfCfe().getCfe().getSituacao()
            ));
            SATResponse satResponse = new SATResponse(
                    resLote.getLote().getNRec(),
                    resLote.getLote().getDhProcessamento(),
                    resLote.getLote().getDhEnvioLote(),
                    Integer.getInteger(resLote.getLote().getQtdeCupoms()),
                    resLote.getLote().getSituacaoLote(),
                    cupomList
            );

            if ( Objects.equals(PropertiesLoader.loadProperties("writeCSV"), "true") && Objects.nonNull(resLote.getLote()) ){
                CSVWriter.writeCSV(resLote);
            }

            SATResponseDAO satResponseDAO = new SATResponseDAO();
            satResponseDAO.save(satResponse);
        }

        return ("Response from SAT server:\n" + (
                (responseObject.getCfeConsultarLotesResult().getResLote().getMensagem().isEmpty())
                        ? ("Success " + responseObject.getCfeConsultarLotesResult().getResLote().getLote().getInfCfe().getCfe().getChave())
                        : ("Failure " + responseObject.getCfeConsultarLotesResult().getResLote().getMensagem())
        ));
    }
}

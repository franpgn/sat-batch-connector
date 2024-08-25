package com.connector.sat.service;

import com.connector.sat.model.CfeConsultarLotesResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Path("/connector")
@ApplicationPath("/sat")
public class SATConnectorService extends Application {
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
        return ("Response from SAT server:\n" + (
                (responseObject.getCfeConsultarLotesResult().getResLote().getMensagem().isEmpty())
                        ? ("Success " + responseObject.getCfeConsultarLotesResult().getResLote().getLote().getInfCfe().getCfe().getChave())
                        : ("Failure " + responseObject.getCfeConsultarLotesResult().getResLote().getMensagem())
        ));
    }
}

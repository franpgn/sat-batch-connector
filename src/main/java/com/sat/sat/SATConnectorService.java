package com.sat.sat;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    public String sendRequest(SATRequest satRequest) throws URISyntaxException, IOException, InterruptedException {
        //send a soap request to the SAT, through the url, and return the response
        String url = "https://wssatsp.fazenda.sp.gov.br/CfeConsultarLotes/CfeConsultarLotes.asmx";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .timeout(Duration.ofSeconds(600))
                .POST(HttpRequest.BodyPublishers.ofString(SOAPBuilder.buildSATRequest(satRequest))).header("Content-Type", "text/xml")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return ("Response from SAT server:\n" + response.body().replaceAll("&gt;", ">").replaceAll("&lt;", "<"));
    }
}

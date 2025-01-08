package com.exemplo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class HttpClientTest {

    @Test
    public void testAccessUrl() throws URISyntaxException, IOException, ParseException {
        // Cria um cliente HTTP
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Define a URL a ser acessada
            URI uri = new URI("https://qastage.buildbox.one/18/cadastro/");
            HttpGet request = new HttpGet(uri);

            // Executa a solicitação HTTP
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // Verifica o status da resposta
                int statusCode = response.getCode();
                assertEquals(200, statusCode);


                // Verifica o conteúdo da resposta
                HttpEntity entity = response.getEntity();
                assertNotNull(entity);
                String responseBody = EntityUtils.toString(entity);
                assertNotNull(responseBody);
                System.out.println(responseBody);
            }
        }
    }
}

package com.redhat.samples.rest.client;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class GreetingClient {

    private static final String BASE_URL = "http://localhost:8080/sample";

    public static void main(String[] args) throws Exception {
        String name = GreetingClient.class.getSimpleName();
        GreetingClient client = new GreetingClient();
        System.out.println(client.request("/hello/", name));
        System.out.println(client.request("/goodbye/", name));
    }

    public String request(String path, String name) {
        ClientRequest request = new ClientRequest(BASE_URL + path + name);
        try {
            ClientResponse<String> response = request.get(String.class);
            if (response.getStatus() == 200) {
                return response.getEntity() != null ? response.getEntity() : null;
            } else {
                return "ERROR: status = " + response.getStatus();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

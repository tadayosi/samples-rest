package com.redhat.samples.rest.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

public class GreetingClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String BASE_URL = String.format("http://%s:%s/sample", HOST, PORT);

    private static final String USERNAME = "quickstartUser";
    private static final String PASSWORD = "quickstartPwd1!";

    public static void main(String[] args) throws Exception {
        String name = GreetingClient.class.getSimpleName();
        GreetingClient client = new GreetingClient();
        System.out.println(client.request("/hello/", name));
        System.out.println(client.request("/goodbye/", name));
    }

    private final ClientExecutor clientExecutor;

    public GreetingClient() {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getCredentialsProvider().setCredentials(new AuthScope(HOST, PORT, AuthScope.ANY_REALM),
                new UsernamePasswordCredentials(USERNAME, PASSWORD));
        clientExecutor = new ApacheHttpClient4Executor(httpClient);
    }

    public String request(String path, String name) {
        ClientRequest request = new ClientRequest(BASE_URL + path + name, clientExecutor);
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

package com.redhat.samples.rest.client;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.redhat.samples.rest.Response;

public class GreetingClient {

  private static final String BASE_URL = "http://localhost:8080/sample";

  public static void main(String[] args) throws Exception {
    String name = GreetingClient.class.getSimpleName();
    request("/hello/", name);
    request("/goodbye/", name);
  }

  private static void request(String path, String name) throws Exception {
    ClientRequest request = new ClientRequest(BASE_URL + path + name);
    ClientResponse<Response> response = request.get(Response.class);
    if (response.getStatus() == 200) {
      System.out.println(response.getEntity());
    }
  }

}

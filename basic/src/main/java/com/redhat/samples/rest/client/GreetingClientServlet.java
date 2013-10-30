package com.redhat.samples.rest.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/client")
public class GreetingClientServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter writer = response.getWriter();
    String name = GreetingClientServlet.class.getSimpleName();
    GreetingClient client = new GreetingClient();
    writer.println(client.request("/hello/", name));
    writer.println(client.request("/goodbye/", name));
  }

}

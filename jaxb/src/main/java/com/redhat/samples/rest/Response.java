package com.redhat.samples.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

  private String message;

  public Response() {}

  public Response(String message) {
    this.message = message;
  }

  @XmlElement
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}

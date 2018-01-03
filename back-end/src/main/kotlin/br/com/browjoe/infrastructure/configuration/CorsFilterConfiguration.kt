package br.com.browjoe.infrastructure.configuration

import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter

class CorsFilterConfiguration : ContainerResponseFilter {

  override fun filter(requestContext: ContainerRequestContext, responseContext: ContainerResponseContext) {
    var headers = responseContext.getHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
  }

}

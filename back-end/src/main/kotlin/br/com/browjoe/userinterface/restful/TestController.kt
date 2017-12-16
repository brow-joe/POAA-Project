package br.com.browjoe.userinterface.restful

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Component
@Path("/test")
@CrossOrigin
open class TestController : DefaultRestController() {
	val logger = LoggerFactory.getLogger(TestController::class.java);

	@GET
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	open fun findAll(): Response {
		logger.info("Request GET from test");
		var content = UUID.randomUUID().toString();
		var resource = createLink(content, this);
		return Response.ok(resource).build();
	}

}
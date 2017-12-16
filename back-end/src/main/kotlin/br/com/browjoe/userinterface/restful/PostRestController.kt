package br.com.browjoe.userinterface.restful

import br.com.browjoe.application.usecase.post.FindAllPostUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Component
@Path("/post")
@CrossOrigin
open class PostRestController : DefaultRestController() {
	val logger = LoggerFactory.getLogger(PostRestController::class.java);

	@Inject
	lateinit var findAllPostUseCase: FindAllPostUseCase;

	@GET
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	open fun findAll(): Response {
		logger.info("GET all posts");
		var resource = createLink(findAllPostUseCase.execute(), this);
		return Response.ok(resource).build();
	}

}
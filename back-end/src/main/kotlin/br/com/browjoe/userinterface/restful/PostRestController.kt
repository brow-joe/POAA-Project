package br.com.browjoe.userinterface.restful

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.usecase.post.DeletePostByIdUseCase
import br.com.browjoe.application.usecase.post.FindAllPostUseCase
import br.com.browjoe.application.usecase.post.FindPostByIdUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Component
@Path("/post")
@CrossOrigin
open class PostRestController : DefaultRestController() {
	val logger = LoggerFactory.getLogger(PostRestController::class.java);

	@Inject
	lateinit var findAllPostUseCase: FindAllPostUseCase;
	@Inject
	lateinit var findPostByIdUseCase: FindPostByIdUseCase;
	@Inject
	lateinit var deletePostByIdUseCase: DeletePostByIdUseCase;

	@GET
	@Path("/")
	@Produces("application/json")
	open fun findAll(): Response {
		logger.info("GET all posts");
		var resource = createLink(findAllPostUseCase.execute(), this);
		return Response.ok(resource).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	open fun findById(@PathParam("id") id: Int): Response {
		logger.info("GET by id={}", id);
		var resource = createLink(findPostByIdUseCase.execute(id), this);
		return Response.ok(resource).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	open fun deleteById(@PathParam("id") id: Int): Response {
		logger.info("DELETE by id={}", id);
		deletePostByIdUseCase.execute(id);
		return Response.ok().build();
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	open fun save(post: PostDTO): Response {
		logger.info("Save post={}", post);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	open fun update(@PathParam("id") id: Int, post: PostDTO): Response {
		logger.info("Update by id={}, post={}", id, post);
		return Response.ok().build();
	}

}
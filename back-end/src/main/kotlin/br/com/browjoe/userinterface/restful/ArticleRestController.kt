package br.com.browjoe.userinterface.restful

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.usecase.article.CreateArticleUseCase
import br.com.browjoe.application.usecase.article.DeleteArticleByIdUseCase
import br.com.browjoe.application.usecase.article.FindAllArticleUseCase
import br.com.browjoe.application.usecase.article.FindArticleByIdUseCase
import br.com.browjoe.application.usecase.article.UpdateArticleUseCase
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
@Path("/article")
@CrossOrigin
open class ArticleRestController : DefaultRestController() {
	val logger = LoggerFactory.getLogger(ArticleRestController::class.java);

	@Inject
	lateinit var findAllArticleUseCase: FindAllArticleUseCase;
	@Inject
	lateinit var findArticleByIdUseCase: FindArticleByIdUseCase;
	@Inject
	lateinit var deleteArticleByIdUseCase: DeleteArticleByIdUseCase;
	@Inject
	lateinit var createArticleUseCase: CreateArticleUseCase;
	@Inject
	lateinit var updateArticleUseCase: UpdateArticleUseCase;

	@GET
	@Path("/")
	@Produces("application/json")
	open fun findAll(): Response {
		logger.info("GET all articles");
		var resource = createLink(findAllArticleUseCase.execute(), this);
		return Response.ok(resource).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	open fun findById(@PathParam("id") id: Int): Response {
		logger.info("GET by id={}", id);
		var resource = createLink(findArticleByIdUseCase.execute(id), this);
		return Response.ok(resource).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	open fun deleteById(@PathParam("id") id: Int): Response {
		logger.info("DELETE by id={}", id);
		deleteArticleByIdUseCase.execute(id);
		var resource = createLink(this);
		return Response.ok(resource).build();
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	open fun save(article: ArticleDTO): Response {
		logger.info("Save article={}", article);
		var resource = createLink(createArticleUseCase.execute(article), this);
		return Response.ok(resource).build();
	}

	@PUT
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	open fun update(@PathParam("id") id: Int, article: ArticleDTO): Response {
		logger.info("Update by id={}, article={}", id, article);
		var resource = createLink(updateArticleUseCase.execute(id, article), this);
		return Response.ok(resource).build();
	}

}
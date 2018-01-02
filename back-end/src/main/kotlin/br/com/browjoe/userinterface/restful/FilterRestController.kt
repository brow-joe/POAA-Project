package br.com.browjoe.userinterface.restful

import br.com.browjoe.application.dto.FilterDTO
import br.com.browjoe.application.usecase.filter.CreateFilterUseCase
import br.com.browjoe.application.usecase.filter.DeleteFilterByIdUseCase
import br.com.browjoe.application.usecase.filter.FindAllFilterUseCase
import br.com.browjoe.application.usecase.score.FindAllScoresByFilterUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.DefaultValue
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response


@Component
@Path("/filter")
@CrossOrigin
open class FilterRestController : DefaultRestController() {
	val logger = LoggerFactory.getLogger(FilterRestController::class.java);

	@Inject
	lateinit var findAllFilterUseCase: FindAllFilterUseCase;
	@Inject
	lateinit var findAllScoresByFilterUseCase: FindAllScoresByFilterUseCase;
	@Inject
	lateinit var deleteFilterByIdUseCase: DeleteFilterByIdUseCase;
	@Inject
	lateinit var createFilterUseCase: CreateFilterUseCase;

	@GET
	@Path("/")
	@Produces("application/json")
	open fun findAll(): Response {
		logger.info("GET all filters");
		var resource = createLink(findAllFilterUseCase.execute(), this);
		return Response.ok(resource).build();
	}

	@GET
	@Path("/{id}/scores")
	@Produces("application/json")
	open fun findScoresByFilter(@PathParam("id") filterId: Int, @DefaultValue("") @QueryParam("grouped") grouped: String): Response {
		logger.info("GET all scores by filter_id={} and grouped={}", filterId, grouped);
		var resource = createLink(findAllScoresByFilterUseCase.execute(filterId, grouped), this);
		return Response.ok(resource).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	open fun deleteById(@PathParam("id") id: Int): Response {
		logger.info("DELETE by id={}", id);
		deleteFilterByIdUseCase.execute(id);
		var resource = createLink(this);
		return Response.ok(resource).build();
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	open fun save(filter: FilterDTO): Response {
		logger.info("Save filter={}", filter);
		var resource = createLink(createFilterUseCase.execute(filter), this);
		return Response.ok(resource).build();
	}

}
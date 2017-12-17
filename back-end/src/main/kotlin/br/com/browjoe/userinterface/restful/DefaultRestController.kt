package br.com.browjoe.userinterface.restful

import br.com.browjoe.userinterface.resource.DataResource
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilder

open class DefaultRestController {

	open fun <C : Any> createLink(controller: C): DataResource<Any> {
		return createLink(null, controller);
	}

	open fun <T, C : Any> createLink(content: T?, controller: C): DataResource<T> {
		val link = JaxRsLinkBuilder.linkTo(controller::class.java).withSelfRel();
		var resource = DataResource(content);
		resource.add(link);
		return resource;
	}

}
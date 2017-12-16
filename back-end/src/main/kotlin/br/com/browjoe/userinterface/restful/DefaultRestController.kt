package br.com.browjoe.userinterface.restful

import br.com.browjoe.userinterface.resource.DataResource
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilder

open class DefaultRestController {

	open fun <T> createLink(content: T, controller: Class<Any>): DataResource<T> {
		val link = JaxRsLinkBuilder.linkTo(controller).withSelfRel();
		var resource = DataResource(content);
		resource.add(link);
		return resource;
	}

}
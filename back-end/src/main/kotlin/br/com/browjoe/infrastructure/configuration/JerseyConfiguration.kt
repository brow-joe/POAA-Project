package br.com.browjoe.infrastructure.configuration

import br.com.browjoe.userinterface.restful.ArticleRestController
import br.com.browjoe.userinterface.restful.PostRestController
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

@Configuration
open class JerseyConfiguration : ResourceConfig() {

	init {
		register(ArticleRestController::class.java);
		register(PostRestController::class.java);
	}

}
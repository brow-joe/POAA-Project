package br.com.browjoe.infrastructure.configuration

import br.com.browjoe.userinterface.restful.ArticleRestController
import br.com.browjoe.userinterface.restful.PostRestController
import org.glassfish.jersey.server.ResourceConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

@Configuration
open class JerseyConfiguration : ResourceConfig() {
	val logger = LoggerFactory.getLogger(JerseyConfiguration::class.java);

	init {
		logger.info("Register all controllers");
		register(ArticleRestController::class.java);
		register(PostRestController::class.java);
	}

}
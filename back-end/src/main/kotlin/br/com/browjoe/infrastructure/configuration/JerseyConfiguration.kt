package br.com.browjoe.infrastructure.configuration

import br.com.browjoe.userinterface.restful.ArticleRestController
import br.com.browjoe.userinterface.restful.FilterRestController
import br.com.browjoe.userinterface.restful.PostRestController
import org.glassfish.jersey.server.ResourceConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import java.util.Arrays

@Configuration
open class JerseyConfiguration : ResourceConfig() {
	val logger = LoggerFactory.getLogger(JerseyConfiguration::class.java);
	val controllers = Arrays.asList(
			ArticleRestController::class.java,
			PostRestController::class.java,
			FilterRestController::class.java
	);

	init {
		logger.info("Register controllers={}", controllers);
		controllers.forEach { register(it) };
	}

}
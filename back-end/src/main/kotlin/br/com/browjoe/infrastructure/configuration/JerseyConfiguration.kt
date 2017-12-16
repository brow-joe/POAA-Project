package br.com.browjoe.infrastructure.configuration

import br.com.browjoe.userinterface.restful.TestController
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

@Configuration
open class JerseyConfiguration : ResourceConfig() {

	init {
		register(TestController::class.java);
	}

}
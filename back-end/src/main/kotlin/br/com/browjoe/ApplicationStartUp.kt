package br.com.browjoe

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
open class ApplicationStartUp : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(ApplicationStartUp::class.java);
	}

}

fun main(args: Array<String>) {
	SpringApplication.run(ApplicationStartUp::class.java, *args);
}
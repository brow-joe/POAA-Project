package br.com.browjoe.application.usecase.post

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.translator.PostTranslator
import br.com.browjoe.infrastructure.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindAllPostUseCase(var translator: PostTranslator, var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(FindAllPostUseCase::class.java);

	fun execute(): List<PostDTO> {
		logger.info("Retrieve all posts");
		return translator.translate(repository.findAll());
	}

}
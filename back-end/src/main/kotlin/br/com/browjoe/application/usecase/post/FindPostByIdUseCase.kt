package br.com.browjoe.application.usecase.post

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.translator.PostTranslator
import br.com.browjoe.infrastructure.repository.PostRepository
import br.com.browjoe.jooq.data.tables.records.PostRecord
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindPostByIdUseCase(var translator: PostTranslator, var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(FindPostByIdUseCase::class.java);

	fun execute(id: Int): PostDTO {
		logger.info("Retrieve post by id={}", id);
		return translator.translate(PostRecord());
	}

}
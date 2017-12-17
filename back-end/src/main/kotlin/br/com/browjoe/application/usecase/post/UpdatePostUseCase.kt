package br.com.browjoe.application.usecase.post

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.translator.PostTranslator
import br.com.browjoe.infrastructure.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class UpdatePostUseCase(var translator: PostTranslator, var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(UpdatePostUseCase::class.java);

	fun execute(id: Int, post: PostDTO): PostDTO {
		logger.info("Update id={} post={}", id, post);
		return post;
	}

}
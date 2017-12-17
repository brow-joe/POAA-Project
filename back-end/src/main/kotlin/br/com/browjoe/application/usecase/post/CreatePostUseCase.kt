package br.com.browjoe.application.usecase.post

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.translator.PostTranslator
import br.com.browjoe.infrastructure.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class CreatePostUseCase(var translator: PostTranslator, var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(CreatePostUseCase::class.java);

	fun execute(post: PostDTO): PostDTO {
		logger.info("Create post={}", post);
		return post;
	}

}
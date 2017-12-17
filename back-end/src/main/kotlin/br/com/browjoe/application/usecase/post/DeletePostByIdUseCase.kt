package br.com.browjoe.application.usecase.post

import br.com.browjoe.infrastructure.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class DeletePostByIdUseCase(var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(DeletePostByIdUseCase::class.java);


	fun execute(id: Int) {
		logger.info("Remove post by id={}", id);
	}

}
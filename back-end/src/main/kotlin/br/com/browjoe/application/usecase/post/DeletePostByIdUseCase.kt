package br.com.browjoe.application.usecase.post

import br.com.browjoe.infrastructure.repository.PostRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class DeletePostByIdUseCase(var repository: PostRepository) {
	val logger = LoggerFactory.getLogger(DeletePostByIdUseCase::class.java);

	@Transactional
	open fun execute(id: Int) {
		logger.info("Remove post by id={}", id);
		repository.delete(id);
	}

}
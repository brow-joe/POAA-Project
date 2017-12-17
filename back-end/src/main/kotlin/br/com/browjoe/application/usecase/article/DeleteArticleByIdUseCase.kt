package br.com.browjoe.application.usecase.article

import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class DeleteArticleByIdUseCase(var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(DeleteArticleByIdUseCase::class.java);

	@Transactional
	open fun execute(id: Int) {
		logger.info("Remove article by id={}", id);
		repository.delete(id);
	}

}
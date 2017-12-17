package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindArticleByIdUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(FindArticleByIdUseCase::class.java);

	fun execute(id: Int): ArticleDTO {
		logger.info("Retrieve article by id={}", id);
		return translator.translate(repository.findById(id));
	}

}
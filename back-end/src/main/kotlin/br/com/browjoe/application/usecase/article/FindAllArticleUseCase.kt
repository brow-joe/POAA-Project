package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindAllArticleUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(FindAllArticleUseCase::class.java);

	fun execute(): List<ArticleDTO> {
		logger.info("Retrieve all articles");
		return translator.translate(repository.findAll());
	}

}
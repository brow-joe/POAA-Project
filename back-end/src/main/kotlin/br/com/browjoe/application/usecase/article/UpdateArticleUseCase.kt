package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class UpdateArticleUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(UpdateArticleUseCase::class.java);

	fun execute(id: Int, article: ArticleDTO): ArticleDTO {
		logger.info("Update id={} article={}", id, article);
		return article;
	}

}
package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class CreateArticleUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(CreateArticleUseCase::class.java);

	@Transactional
	fun execute(article: ArticleDTO): ArticleDTO {
		logger.info("Create article={}", article);
		var id = repository.save(translator.translate(article));
		return translator.translate(repository.findById(id));
	}

}
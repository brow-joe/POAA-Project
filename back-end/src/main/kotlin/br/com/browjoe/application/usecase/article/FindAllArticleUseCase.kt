package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
open class FindAllArticleUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {

	fun execute(): List<ArticleDTO> {
		return translator.translate(repository.findAll());
	}

}
package br.com.browjoe.application.usecase.article

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.application.translator.ArticleTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Objects

@Service
open class UpdateArticleUseCase(var translator: ArticleTranslator, var repository: ArticleRepository) {
	val logger = LoggerFactory.getLogger(UpdateArticleUseCase::class.java);

	@Transactional
	open fun execute(id: Int?, article: ArticleDTO): ArticleDTO {
		logger.info("Update id={} article={}", id, article);
		if (Objects.nonNull(id)) {
			article.id = id;
		}
		return translator.translate(repository.update(translator.translate(article)));
	}

}
package br.com.browjoe.application.translator

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.jooq.data.tables.records.ArticleRecord
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
open class ArticleTranslator {
	val logger = LoggerFactory.getLogger(ArticleTranslator::class.java);

	fun translate(record: Result<ArticleRecord>): List<ArticleDTO> {
		logger.info("Translate result to list: {}", record.size);
		return record.map { translate(it) }.toList();
	}

	fun translate(record: ArticleRecord): ArticleDTO {
		return ArticleDTO(record.value1(), record.value2(), record.value3(), record.value4(), record.value5());
	}

	fun translate(article: ArticleDTO): ArticleRecord {
		return ArticleRecord(article.id, article.internalId, article.published, article.title, article.slug);
	}

}
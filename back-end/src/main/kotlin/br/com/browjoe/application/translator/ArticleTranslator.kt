package br.com.browjoe.application.translator

import br.com.browjoe.application.dto.ArticleDTO
import br.com.browjoe.jooq.data.tables.records.ArticleRecord
import org.jooq.Result
import org.springframework.stereotype.Component

@Component
open class ArticleTranslator {

	fun translate(record: Result<ArticleRecord>): List<ArticleDTO> {
		return record.map { translate(it) }.toList()
	}

	fun translate(record: ArticleRecord): ArticleDTO {
		return ArticleDTO(record.value1(), record.value2(), record.value3(), record.value4(), record.value5());
	}

}
package br.com.browjoe.application.translator

import br.com.browjoe.application.dto.ScoreDTO
import br.com.browjoe.jooq.data.tables.records.ArticleScoreRecord
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
open class ScoreTranslator {
	val logger = LoggerFactory.getLogger(ScoreTranslator::class.java);

	fun translate(record: Result<ArticleScoreRecord>): List<ScoreDTO> {
		logger.info("Translate result to list: {}", record.size);
		return record.map { translate(it) }.toList();
	}

	fun translate(record: ArticleScoreRecord): ScoreDTO {
		return ScoreDTO(record.value1(), record.value2(), record.value3(), record.value4(), record.value5());
	}

	fun translate(dto: ScoreDTO): ArticleScoreRecord {
		return ArticleScoreRecord(dto.id, dto.articleId, dto.filterId, dto.score, dto.grouped);
	}
}
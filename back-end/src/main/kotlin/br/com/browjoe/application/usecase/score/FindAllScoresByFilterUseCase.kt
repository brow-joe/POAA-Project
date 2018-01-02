package br.com.browjoe.application.usecase.score

import br.com.browjoe.application.dto.ScoreDTO
import br.com.browjoe.application.translator.ScoreTranslator
import br.com.browjoe.infrastructure.repository.ScoreRepository
import br.com.browjoe.jooq.data.tables.records.ArticleScoreRecord
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindAllScoresByFilterUseCase(var translator: ScoreTranslator, var repository: ScoreRepository) {
	val logger = LoggerFactory.getLogger(FindAllScoresByFilterUseCase::class.java);

	fun execute(filterId: Int, grouped: String): List<ScoreDTO> {
		logger.info("Retrieve all scores by filter_id={} and grouped={}", filterId, grouped);
		var result: Result<ArticleScoreRecord>;
		if (grouped.isEmpty()) {
			result = repository.findAllByFilter(filterId);
		} else {
			result = repository.findAllByFilterAndGroup(filterId, grouped);
		}
		return translator.translate(result);
	}

}
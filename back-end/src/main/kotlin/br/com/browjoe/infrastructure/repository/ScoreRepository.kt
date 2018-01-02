package br.com.browjoe.infrastructure.repository

import br.com.browjoe.jooq.data.tables.ArticleScore
import br.com.browjoe.jooq.data.tables.records.ArticleScoreRecord
import org.jooq.DSLContext
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class ScoreRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(ScoreRepository::class.java);
	val table = ArticleScore.ARTICLE_SCORE;

	fun findAllByFilter(filterId: Int): Result<ArticleScoreRecord> {
		logger.info("Find all by filter_id={}", filterId);
		return dsl.selectFrom(table).where(table.FILTER_ID.eq(filterId)).fetch();
	}

	fun findAllByFilterAndGroup(filterId: Int, grouped: String): Result<ArticleScoreRecord> {
		logger.info("Find all by filter_id={} and grouped={}", filterId, grouped);
		return dsl.selectFrom(table)
				.where(table.FILTER_ID.eq(filterId))
				.and(table.GROUPED.eq(grouped)).fetch();
	}

	fun deleteScoresByFilter(filterId: Int) {
		logger.info("Delete all by filter_id={}", filterId);
		dsl.deleteFrom(table).where(table.FILTER_ID.eq(filterId)).execute();
	}

	fun save(record: ArticleScoreRecord): ArticleScoreRecord {
		logger.info("Create={}", record);
		return dsl.insertInto(table,
				table.ARTICLE_ID, table.FILTER_ID, table.SCORE, table.GROUPED
		).values(
				record.getArticleId(), record.getFilterId(), record.getScore(), record.getGrouped()
		).returning().fetchOne();
	}

}
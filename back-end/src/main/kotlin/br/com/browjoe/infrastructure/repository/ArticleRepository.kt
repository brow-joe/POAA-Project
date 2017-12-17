package br.com.browjoe.infrastructure.repository

import br.com.browjoe.jooq.data.tables.Article
import br.com.browjoe.jooq.data.tables.records.ArticleRecord
import org.jooq.DSLContext
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class ArticleRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(ArticleRepository::class.java);
	val table = Article.ARTICLE;

	fun findAll(): Result<ArticleRecord> {
		logger.info("Find all");
		return dsl.selectFrom(table).fetch();
	}

	fun findById(id: Int): ArticleRecord {
		logger.info("Find by id={}", id);
		return dsl.selectFrom(table).where(table.ID.eq(id)).fetchOne();
	}

	fun save(article: ArticleRecord): Int {
		logger.info("Create={}", article);
		return dsl.insertInto(table).set(article).execute();
	}

}
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

	fun save(article: ArticleRecord): ArticleRecord {
		logger.info("Create={}", article);
		return dsl.insertInto(table,
				table.WP_INTERNAL_ID, table.WP_PUBLISHED_TIME,
				table.TITLE, table.SLUG
		).values(
				article.getWpInternalId(), article.getWpPublishedTime(),
				article.getTitle(), article.getSlug()
		).returning().fetchOne();
	}

	fun delete(id: Int) {
		logger.info("Delete by id={}", id);
		dsl.deleteFrom(table).where(table.ID.eq(id)).execute();
	}

	fun update(article: ArticleRecord): ArticleRecord {
		logger.info("Update={}", article);
		return dsl.update(table).set(article).returning().fetchOne();
	}

}
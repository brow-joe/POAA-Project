package br.com.browjoe.infrastructure.repository

import br.com.browjoe.jooq.data.tables.Post
import br.com.browjoe.jooq.data.tables.records.PostRecord
import org.jooq.DSLContext
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
open class PostRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(PostRepository::class.java);
	val table = Post.POST;

	fun findAll(): Result<PostRecord> {
		logger.info("Find All");
		return dsl.selectFrom(table).fetch();
	}

	fun findAllBetween(startDate: Timestamp, endDate: Timestamp): Result<PostRecord> {
		logger.info("Find all between published start={}, end={}", startDate, endDate);
		return dsl.selectFrom(table).where(table.FB_PUBLISHED_DATE.between(startDate, endDate)).fetch();
	}

	fun findById(id: Int): PostRecord {
		logger.info("Find by id={}", id);
		return dsl.selectFrom(table).where(table.ID.eq(id)).fetchOne();
	}

	fun save(post: PostRecord): PostRecord {
		logger.info("Create={}", post);
		return dsl.insertInto(table,
				table.FB_INTERNAL_ID, table.FB_PUBLISHED_DATE,
				table.FB_TITLE, table.FB_LINK,
				table.FB_DESCRIPTION, table.LIKES,
				table.SHARES, table.COMMENTS, table.CONSUMPTIONS
		).values(
				post.getFbInternalId(), post.getFbPublishedDate(),
				post.getFbTitle(), post.getFbLink(),
				post.getFbDescription(), post.getLikes(),
				post.getShares(), post.getComments(), post.getConsumptions()
		).returning().fetchOne();
	}

	fun delete(id: Int) {
		logger.info("Delete by id={}", id);
		dsl.deleteFrom(table).where(table.ID.eq(id)).execute();
	}

	fun update(post: PostRecord): PostRecord {
		logger.info("Update={}", post);
		return dsl.update(table).set(post).returning().fetchOne();
	}

}
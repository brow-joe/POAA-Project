package br.com.browjoe.infrastructure.repository

import br.com.browjoe.jooq.data.tables.Post
import br.com.browjoe.jooq.data.tables.records.PostRecord
import org.jooq.DSLContext
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class PostRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(PostRepository::class.java);
	val table = Post.POST;

	fun findAll(): Result<PostRecord> {
		logger.info("Find All");
		return dsl.selectFrom(table).fetch();
	}

	fun findById(id: Int): PostRecord {
		logger.info("Find by id={}", id);
		return dsl.selectFrom(table).where(table.ID.eq(id)).fetchOne();
	}

	fun save(post: PostRecord): Int {
		logger.info("Create={}", post);
		return dsl.insertInto(table).set(post).execute();
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
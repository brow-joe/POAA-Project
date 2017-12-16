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

	fun findAll(): Result<PostRecord> {
		return dsl.selectFrom(Post.POST).fetch();
	}

}
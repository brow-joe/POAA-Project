package br.com.browjoe.infrastructure.repository

import org.jooq.DSLContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class ArticleRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(ArticleRepository::class.java);

}
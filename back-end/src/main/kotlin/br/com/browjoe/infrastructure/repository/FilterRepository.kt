package br.com.browjoe.infrastructure.repository

import br.com.browjoe.jooq.data.tables.Filter
import br.com.browjoe.jooq.data.tables.records.FilterRecord
import org.jooq.DSLContext
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FilterRepository(var dsl: DSLContext) {
	val logger = LoggerFactory.getLogger(FilterRepository::class.java);
	val table = Filter.FILTER;

	fun findAll(): Result<FilterRecord> {
		logger.info("Find all");
		return dsl.selectFrom(table).fetch();
	}

	fun save(filter: FilterRecord): FilterRecord {
		logger.info("Create={}", filter);
		return dsl.insertInto(table,
				table.START_DATE, table.END_DATE
		).values(
				filter.getStartDate(), filter.getEndDate()
		).returning().fetchOne();
	}

	fun delete(id: Int) {
		logger.info("Delete by id={}", id);
		dsl.deleteFrom(table).where(table.ID.eq(id)).execute();
	}

}
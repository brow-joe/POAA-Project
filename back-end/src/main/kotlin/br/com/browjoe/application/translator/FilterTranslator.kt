package br.com.browjoe.application.translator

import br.com.browjoe.application.dto.FilterDTO
import br.com.browjoe.jooq.data.tables.records.FilterRecord
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
open class FilterTranslator {
	val logger = LoggerFactory.getLogger(FilterTranslator::class.java);

	fun translate(record: Result<FilterRecord>): List<FilterDTO> {
		logger.info("Translate result to list: {}", record.size);
		return record.map { translate(it) }.toList();
	}

	fun translate(record: FilterRecord): FilterDTO {
		return FilterDTO(record.value1(), record.value2(), record.value3());
	}

	fun translate(filter: FilterDTO): FilterRecord {
		return FilterRecord(filter.id, filter.startDate, filter.endDate);
	}
}
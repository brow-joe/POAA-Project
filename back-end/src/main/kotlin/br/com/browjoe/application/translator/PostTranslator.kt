package br.com.browjoe.application.translator

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.jooq.data.tables.records.PostRecord
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
open class PostTranslator {
	val logger = LoggerFactory.getLogger(PostTranslator::class.java);

	fun translate(record: Result<PostRecord>): List<PostDTO> {
		logger.info("Translate result to list: {}", record.size);
		return record.map { translate(it) }.toList();
	}

	fun translate(record: PostRecord): PostDTO {
		return PostDTO(
				record.value1(), record.value2(),
				record.value3(), record.value4(),
				record.value5(), record.value6(),
				record.value7(), record.value8(),
				record.value9(), record.value10()
		);
	}

}
package br.com.browjoe.application.usecase.filter

import br.com.browjoe.application.dto.FilterDTO
import br.com.browjoe.application.translator.FilterTranslator
import br.com.browjoe.infrastructure.repository.FilterRepository
import br.com.browjoe.infrastructure.service.CreateScoresByFilterService
import br.com.browjoe.jooq.data.tables.records.FilterRecord
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class CreateFilterUseCase(var translator: FilterTranslator, var service: CreateScoresByFilterService, var repository: FilterRepository) {
	val logger = LoggerFactory.getLogger(CreateFilterUseCase::class.java);

	open fun execute(filter: FilterDTO): FilterDTO {
		logger.info("Create filter={}", filter);
		var record = save(filter);
		service.process(record);
		return translator.translate(record);
	}

	@Transactional
	internal open fun save(filter: FilterDTO): FilterRecord {
		return repository.save(translator.translate(filter));
	}

}
package br.com.browjoe.application.usecase.filter

import br.com.browjoe.application.dto.FilterDTO
import br.com.browjoe.application.translator.FilterTranslator
import br.com.browjoe.infrastructure.repository.FilterRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class FindAllFilterUseCase(var translator: FilterTranslator, var repository: FilterRepository) {
	val logger = LoggerFactory.getLogger(FindAllFilterUseCase::class.java);

	fun execute(): List<FilterDTO> {
		logger.info("Retrieve all filters");
		return translator.translate(repository.findAll());
	}

}
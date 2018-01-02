package br.com.browjoe.application.usecase.filter

import br.com.browjoe.infrastructure.service.RemoveScoresAndFilterService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class DeleteFilterByIdUseCase(var service: RemoveScoresAndFilterService) {
	val logger = LoggerFactory.getLogger(DeleteFilterByIdUseCase::class.java);

	@Transactional
	open fun execute(id: Int) {
		logger.info("Remove filter by id={}", id);
		service.process(id);
	}

}
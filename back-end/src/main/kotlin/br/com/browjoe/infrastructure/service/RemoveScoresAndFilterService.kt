package br.com.browjoe.infrastructure.service

import br.com.browjoe.infrastructure.repository.FilterRepository
import br.com.browjoe.infrastructure.repository.ScoreRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.inject.Inject

@Service
open class RemoveScoresAndFilterService() {
	val logger = LoggerFactory.getLogger(RemoveScoresAndFilterService::class.java);

	@Inject
	lateinit var filterRepository: FilterRepository;
	@Inject
	lateinit var scoreRepository: ScoreRepository;

	@Transactional
	open fun process(filterId: Int) {
		logger.info("Remove scores cascade by filter_id={}", filterId);
		removeScoresByFilter(filterId);
		removeFilter(filterId);
	}

	internal open fun removeScoresByFilter(filterId: Int) {
		scoreRepository.deleteScoresByFilter(filterId);
	}

	internal open fun removeFilter(filterId: Int) {
		filterRepository.delete(filterId);
	}

}
package br.com.browjoe.infrastructure.service

import br.com.browjoe.application.dto.ScoreDTO
import br.com.browjoe.application.translator.ScoreTranslator
import br.com.browjoe.infrastructure.repository.ArticleRepository
import br.com.browjoe.infrastructure.repository.PostRepository
import br.com.browjoe.infrastructure.repository.ScoreRepository
import br.com.browjoe.jooq.data.tables.records.ArticleRecord
import br.com.browjoe.jooq.data.tables.records.FilterRecord
import br.com.browjoe.jooq.data.tables.records.PostRecord
import com.google.common.collect.Lists
import org.jooq.Result
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.inject.Inject

@Service
open class CreateScoresByFilterService() {
	val logger = LoggerFactory.getLogger(CreateScoresByFilterService::class.java);

	val linkPrefix = "https://lamenteesmaravillosa.com/";
	val linkSuffix = "/";

	val shareWeights = 0.6;
	val commentWeights = 0.2;
	val likeWeights = 0.1;
	val consumptionsWeights = 0.1;
	val limitWeights = 0.7;

	val groupedLimit = 10;
	val groupedPrefix = "Pack ";
	val groupedSuffix = " LMEM";

	@Inject
	lateinit var articleRepository: ArticleRepository;
	@Inject
	lateinit var postRepository: PostRepository;
	@Inject
	lateinit var scoreRepository: ScoreRepository;
	@Inject
	lateinit var scoreTranslator: ScoreTranslator;

	//@Async
	open fun process(filter: FilterRecord) {
		logger.info("Process scores by filter={}", filter);
		var posts = postRepository.findAllBetween(filter.startDate, filter.endDate);
		var scores = posts.map { Pair(it, findArticlesByPost(it)) }
				.filter { it.second.size > 0 }
				.map { Pair(it.first, it.second.first()) }
				.map { createScore(it.second, filter, it.first) }
				.groupBy { it.articleId }
				.map { averageScores(it.value) }
				.sortedBy { it.score }.reversed()
				.toList();

		scores = scores.subList(0, (scores.size * limitWeights).toInt()).toList();
		var batch = scores.size / (groupedLimit - 1);
		var partition = Lists.partition(scores, batch);

		for (index in 1..partition.size) {
			var grouped = groupedPrefix + index + groupedSuffix;
			saveScores(grouped, partition.get(index - 1));
		}

	}

	internal open fun saveScores(grouped: String, scores: List<ScoreDTO>) {
		scores.forEach { saveScore(grouped, it) };
	}

	internal open fun saveScore(grouped: String, score: ScoreDTO) {
		score.grouped = grouped;
		scoreRepository.save(scoreTranslator.translate(score));
	}

	internal open fun findArticlesByPost(post: PostRecord): Result<ArticleRecord> {
		var slug = post.fbLink.removePrefix(linkPrefix).removeSuffix(linkSuffix);
		return articleRepository.findBySlugOrTitle(slug, post.fbTitle);
	}

	internal open fun createScore(article: ArticleRecord, filter: FilterRecord, post: PostRecord): ScoreDTO {
		return ScoreDTO(null, article.id, filter.id, calculeScore(post), null);
	}

	internal open fun calculeScore(post: PostRecord): Double {
		var likeScore = post.likes * likeWeights;
		var shareScore = post.shares * shareWeights;
		var commentScore = post.comments * commentWeights;
		var consumptionsScore = post.consumptions * consumptionsWeights;
		return doubleArrayOf(likeScore, shareScore, commentScore, consumptionsScore).average();
	}

	internal open fun averageScores(scores: List<ScoreDTO>): ScoreDTO {
		var data = scores.first();
		data.score = scores.stream().mapToDouble { it.score as Double }.sum() / scores.size;
		return data;
	}

}
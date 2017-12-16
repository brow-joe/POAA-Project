package br.com.browjoe.test

import br.com.browjoe.userinterface.restful.ArticleRestController
import br.com.browjoe.userinterface.restful.PostRestController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.Objects
import javax.inject.Inject
import kotlin.test.assertTrue

@RunWith(SpringRunner::class)
@SpringBootTest
class ApiTest {

	@Inject
	lateinit var postRestController: PostRestController;
	@Inject
	lateinit var articleRestController: ArticleRestController;

	@Test
	fun postTest() {
		var result = postRestController.findAll();
		assertTrue(Objects.nonNull(result.getEntity()));
	}

	@Test
	fun articleTest() {
		var result = articleRestController.findAll();
		assertTrue(Objects.nonNull(result.getEntity()));
	}

}
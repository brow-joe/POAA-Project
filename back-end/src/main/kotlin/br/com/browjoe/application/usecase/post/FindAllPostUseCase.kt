package br.com.browjoe.application.usecase.post

import br.com.browjoe.application.dto.PostDTO
import br.com.browjoe.application.translator.PostTranslator
import br.com.browjoe.infrastructure.repository.PostRepository
import org.springframework.stereotype.Service

@Service
open class FindAllPostUseCase(var translator: PostTranslator, var repository: PostRepository) {

	fun execute(): List<PostDTO> {
		return translator.translate(repository.findAll());
	}

}
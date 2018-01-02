package br.com.browjoe.application.dto

import java.io.Serializable
import javax.xml.bind.annotation.XmlRootElement

/**
 * @see json:

{"id": 0,
"articleId": 0,
"filterId": 0,
"score": 0.00,
"grouped": ""}

 */
@XmlRootElement
data class ScoreDTO(
		var id: Int? = null,
		val articleId: Int? = null,
		val filterId: Int? = null,
		var score: Double? = null,
		var grouped: String? = null
) : Serializable
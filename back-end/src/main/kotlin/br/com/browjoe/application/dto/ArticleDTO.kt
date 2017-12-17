package br.com.browjoe.application.dto

import java.io.Serializable
import java.util.Date
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class ArticleDTO(
		var id: Int? = 0,
		val internalId: Long? = 0,
		val published: Date? = Date(),
		val title: String? = "",
		val slug: String? = ""
) : Serializable
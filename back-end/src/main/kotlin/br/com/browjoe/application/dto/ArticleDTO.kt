package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
import java.util.Date
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class ArticleDTO(
		var id: Int? = 0,
		val internalId: Long? = 0,
		val published: Timestamp? = Timestamp(Date().getTime()),
		val title: String? = "",
		val slug: String? = ""
) : Serializable
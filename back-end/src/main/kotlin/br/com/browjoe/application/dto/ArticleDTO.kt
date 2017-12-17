package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
import java.util.Date
import javax.xml.bind.annotation.XmlRootElement

/**
 * @see json:

{"id": 0,
"internalId": 0,
"published": 1513523432315,
"title": "",
"slug": ""}

 */
@XmlRootElement
data class ArticleDTO(
		var id: Int? = 0,
		val internalId: Long? = 0,
		val published: Timestamp? = Timestamp(Date().getTime()),
		val title: String? = "",
		val slug: String? = ""
) : Serializable
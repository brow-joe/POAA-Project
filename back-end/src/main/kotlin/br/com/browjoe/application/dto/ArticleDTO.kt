package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
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
		var id: Int? = null,
		val internalId: Long? = null,
		val published: Timestamp? = null,
		val title: String? = null,
		val slug: String? = null
) : Serializable
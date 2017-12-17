package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
import javax.xml.bind.annotation.XmlRootElement

/**
 * @see json:

{"id": 0,
"internalId": "",
"published": 1513523431153,
"title": "",
"link": "",
"description": "",
"likes": 0,
"shares": 0,
"comments": 0,
"consumptions": 0}

 */
@XmlRootElement
data class PostDTO(
		var id: Int? = null,
		val internalId: String? = null,
		val published: Timestamp? = null,
		val title: String? = null,
		val link: String? = null,
		val description: String? = null,
		val likes: Int? = null,
		val shares: Int? = null,
		val comments: Int? = null,
		val consumptions: Int? = null
) : Serializable
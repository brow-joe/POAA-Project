package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
import java.util.Date
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
		var id: Int? = 0,
		val internalId: String? = "",
		val published: Timestamp? = Timestamp(Date().getTime()),
		val title: String? = "",
		val link: String? = "",
		val description: String? = "",
		val likes: Int? = 0,
		val shares: Int? = 0,
		val comments: Int? = 0,
		val consumptions: Int? = 0
) : Serializable
package br.com.browjoe.application.dto

import java.io.Serializable
import java.util.Date
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class PostDTO(
		var id: Int? = 0,
		val internalId: String? = "",
		val published: Date? = Date(),
		val title: String? = "",
		val link: String? = "",
		val description: String? = "",
		val likes: Int? = 0,
		val shares: Int? = 0,
		val comments: Int? = 0,
		val onsumptions: Int? = 0
) : Serializable
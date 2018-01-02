package br.com.browjoe.application.dto

import java.io.Serializable
import java.sql.Timestamp
import javax.xml.bind.annotation.XmlRootElement

/**
 * @see json:

{"id": 0,
"startDate": 1513523432315,
"endDate": 1513523432315}

 */
@XmlRootElement
data class FilterDTO(
		var id: Int? = null,
		val startDate: Timestamp? = null,
		val endDate: Timestamp? = null
) : Serializable
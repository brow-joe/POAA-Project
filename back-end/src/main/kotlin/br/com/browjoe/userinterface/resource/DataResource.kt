package br.com.browjoe.userinterface.resource

import org.springframework.hateoas.ResourceSupport

class DataResource<T>(val content: T) : ResourceSupport()
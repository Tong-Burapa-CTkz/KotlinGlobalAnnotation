package com.playground.kotlinGlobalAnnotation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinGlobalAnnotationApplication

fun main(args: Array<String>) {
	runApplication<KotlinGlobalAnnotationApplication>(*args)
}

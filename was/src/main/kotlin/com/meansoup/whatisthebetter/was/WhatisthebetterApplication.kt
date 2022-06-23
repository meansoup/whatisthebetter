package com.meansoup.whatisthebetter.was

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.meansoup.whatisthebetter"])
class WhatisthebetterApplication

fun main(args: Array<String>) {
	runApplication<WhatisthebetterApplication>(*args)
}

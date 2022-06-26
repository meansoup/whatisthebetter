package com.meansoup.whatisthebetter.application.exception

open class ApplicationException(message: String): RuntimeException(message)

class InvalidTypeException(message: String): ApplicationException(message)
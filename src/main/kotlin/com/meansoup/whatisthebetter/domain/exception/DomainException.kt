package com.meansoup.whatisthebetter.domain.exception

open class DomainException(message: String): RuntimeException(message)

class TooLongUsernameException(message: String): DomainException(message)
class TooSmallUsernameException(message: String): DomainException(message)
class InvalidCharacterInUsernameException(message: String): DomainException(message)

class InvalidEmailException(message: String): DomainException(message)
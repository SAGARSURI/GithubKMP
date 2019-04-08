package com.example

import kotlin.coroutines.CoroutineContext

expect fun platformName(): String

class Greetings{
    fun greeting():String = "Hello ${platformName()}"
}

internal expect val ApplicationDispatcher: CoroutineContext
package com.example
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

internal actual val ApplicationDispatcher: CoroutineContext = Dispatchers.IO
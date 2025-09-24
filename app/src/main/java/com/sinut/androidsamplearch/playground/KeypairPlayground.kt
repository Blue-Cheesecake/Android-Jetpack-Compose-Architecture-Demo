package com.sinut.androidsamplearch.playground

import com.sinut.androidsamplearch.domain.usecase.GenerateKeypairUseCase
import kotlinx.coroutines.runBlocking
import java.util.Base64

fun main(): Unit = runBlocking {
    val g = GenerateKeypairUseCase()
    val r = g.execute(Unit)
    Base64.getEncoder()

    r.onSuccess { kp ->

        println("Public key: ${kp.public}")
        println("Private key: ${kp.private}")
    }
}
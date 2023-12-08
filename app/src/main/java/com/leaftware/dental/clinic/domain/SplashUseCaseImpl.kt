package com.leaftware.dental.clinic.domain

import kotlinx.coroutines.delay

class SplashUseCaseImpl : SplashUseCase {
    override suspend fun simulateSplashDelay() {
        delay(2000)
    }
}
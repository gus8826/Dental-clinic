package com.leaftware.dental.clinic.di

import com.leaftware.dental.clinic.core.ApiClient
import com.leaftware.dental.clinic.data.network.ApiService
import com.leaftware.dental.clinic.ui.views.singup.Splash.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiClient(apiService: ApiService): ApiClient {
        return ApiClient(apiService)
    }

    @Provides
    fun provideSplashViewModel(): SplashViewModel {
        return SplashViewModel()
    }
}
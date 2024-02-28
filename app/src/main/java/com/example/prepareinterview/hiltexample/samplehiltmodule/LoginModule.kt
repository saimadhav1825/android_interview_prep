package com.example.prepareinterview.hiltexample.samplehiltmodule

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object LoginModule {

    @Provides
    @Named("LoginApiService")
    fun provideLoginService(): SampleApiService {
        return LoginApiService()
    }

    @Provides
    @Named("RegistrationApiService")
    fun provideRegistrationApiService(): SampleApiService {
        return RegistrationApiService()
    }
}
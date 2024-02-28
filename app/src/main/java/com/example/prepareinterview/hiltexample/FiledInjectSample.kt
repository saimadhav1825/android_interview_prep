package com.example.prepareinterview.hiltexample
import com.example.prepareinterview.hiltexample.samplehiltmodule.SampleApiService
import javax.inject.Inject
import javax.inject.Named

class FiledInjectSample @Inject constructor(
    constructionInjectionSample: ConstructionInjectionSample,
    @Named("LoginApiService") loginApiService: SampleApiService,
    @Named("RegistrationApiService") registrationApiService: SampleApiService) {
    init {
        constructionInjectionSample.constructionInjectionSample()
        registrationApiService.loginCall()
        loginApiService.loginCall()
    }

    fun sampleFiledInjection() {
        println("sampleFiledInjection")
    }
}
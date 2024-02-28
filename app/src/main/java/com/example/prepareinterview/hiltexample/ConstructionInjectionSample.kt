package com.example.prepareinterview.hiltexample

import javax.inject.Inject

class ConstructionInjectionSample @Inject constructor() {
    fun constructionInjectionSample(){
        println("constructionInjectionSample")
    }
}
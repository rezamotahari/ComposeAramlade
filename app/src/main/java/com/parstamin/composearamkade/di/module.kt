package com.parstamin.composearamkade.di

import com.parstamin.composearamkade.data.network.KtorApiService
import com.parstamin.composearamkade.data.network.KtorApiServiceImpl
import com.parstamin.composearamkade.data.repository.MeditationRepository
import com.parstamin.composearamkade.ui.viewmodel.MeditationViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    viewModel { MeditationViewModel(get()) }



/*    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                        coerceInputValues = true
                        prettyPrint = true
                        isLenient = true
                        explicitNulls = false

                    }
                )
            }
        }


    }*/


    singleOf(::KtorApiServiceImpl) { bind<KtorApiService>() }
    singleOf(::MeditationRepository)


}

val httpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                        coerceInputValues = true
                        prettyPrint = true
                        isLenient = true
                        explicitNulls = false
                    }
                )
            }
        }
    }
}
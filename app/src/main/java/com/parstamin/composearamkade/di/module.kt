package com.parstamin.composearamkade.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.parstamin.composearamkade.data.local.PersonDataSource
import com.parstamin.composearamkade.data.local.PersonDataSourceImpl
import com.parstamin.composearamkade.data.network.KtorApiService
import com.parstamin.composearamkade.data.network.KtorApiServiceImpl
import com.parstamin.composearamkade.data.repository.MeditationRepository
import com.parstamin.composearamkade.db.Database
import com.parstamin.composearamkade.ui.viewmodel.MeditationViewModel
import com.parstamin.composearamkade.ui.viewmodel.PersonListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    viewModel { MeditationViewModel(get()) }
    viewModel { PersonListViewModel(get()) }



    single { provideSqlDriver(androidApplication()) }
    single { providePersonDataSource(get()) }

    singleOf(::KtorApiServiceImpl) { bind<KtorApiService>() }
    singleOf(::MeditationRepository)


}

fun provideSqlDriver(app: Application): SqlDriver {
    return AndroidSqliteDriver(
        schema = Database.Schema,
        context = app,
        name = "User.db"
    )
}

fun providePersonDataSource(driver: SqlDriver): PersonDataSource {
    return PersonDataSourceImpl(Database(driver))
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
package com.parstamin.composearamkade.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.parstamin.composearamkade.data.network.ApiServices
import com.parstamin.composearamkade.utils.BASE_URL
import com.parstamin.composearamkade.utils.CONNECTION_TIME
import com.parstamin.composearamkade.utils.NAMED_PING
import com.parstamin.composearamkade.utils.PING_INTERVAL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, client: OkHttpClient): ApiServices =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices::class.java)

    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideClient(
        timeout: Long, @Named(NAMED_PING) ping: Long
    ) = OkHttpClient.Builder()


.also { client ->

        }
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS)
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .pingInterval(ping, TimeUnit.SECONDS)
        .build()



    @Provides
    @Singleton
    fun provideTimeout() = CONNECTION_TIME

    @Provides
    @Singleton
    @Named(NAMED_PING)
    fun providePingInterval() = PING_INTERVAL
}

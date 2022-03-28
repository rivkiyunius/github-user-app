package com.qatros.githubuserapp.di

import com.qatros.githubuserapp.BuildConfig
import com.qatros.githubuserapp.model.ApiService
import com.qatros.githubuserapp.repository.DataRepository
import com.qatros.githubuserapp.repository.DataRepositoryImpl
import com.qatros.githubuserapp.repository.localdatasources.LocalDataSource
import com.qatros.githubuserapp.repository.localdatasources.LocalDataSourcesImpl
import com.qatros.githubuserapp.repository.remotedatasources.RemoteDataSources
import com.qatros.githubuserapp.repository.remotedatasources.RemoteDataSourcesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author rivki
 * Created 24/03/22 at 12.27
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {
    @Provides
    @Singleton
    fun provideOkHttpLogger(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val builder = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "token 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")
                chain.proceed(builder.build())
            }
            addInterceptor(logging)
            connectTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
            readTimeout(30L, TimeUnit.SECONDS)
        }
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}
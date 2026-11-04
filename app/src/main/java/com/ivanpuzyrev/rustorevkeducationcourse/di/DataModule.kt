package com.ivanpuzyrev.rustorevkeducationcourse.di

import com.ivanpuzyrev.rustorevkeducationcourse.data.AppListApi
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepositoryImpl
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

    companion object {
        @Provides
        fun provideAppListApi(): AppListApi {
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://185.103.109.134/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create<AppListApi>()
        }
    }
}
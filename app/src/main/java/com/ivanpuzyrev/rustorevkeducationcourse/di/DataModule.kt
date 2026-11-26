package com.ivanpuzyrev.rustorevkeducationcourse.di

import android.content.Context
import androidx.room.Room
import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepositoryImpl
import com.ivanpuzyrev.rustorevkeducationcourse.data.api.AppListApi
import com.ivanpuzyrev.rustorevkeducationcourse.data.db.AppDAO
import com.ivanpuzyrev.rustorevkeducationcourse.data.db.AppDatabase
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

    companion object {

        @Provides
        @Singleton
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

        @Provides
        @Singleton
        fun provideAppDAO(@ApplicationContext context: Context): AppDAO {
            val db = Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
                .fallbackToDestructiveMigration(false).build()
            return db.getAppDAO()
        }
    }
}
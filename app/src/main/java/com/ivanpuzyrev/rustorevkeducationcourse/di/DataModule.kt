package com.ivanpuzyrev.rustorevkeducationcourse.di

import com.ivanpuzyrev.rustorevkeducationcourse.data.AppRepositoryImpl
import com.ivanpuzyrev.rustorevkeducationcourse.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository
}
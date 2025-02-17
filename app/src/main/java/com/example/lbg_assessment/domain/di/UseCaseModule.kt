package com.example.lbg_assessment.domain.di

import com.example.lbg_assessment.data.repository.ProductRepositoryImpl
import com.example.lbg_assessment.domain.useCase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: ProductRepositoryImpl) : GetProductListUseCase {
        return GetProductListUseCase(repositoryImpl)
    }
}
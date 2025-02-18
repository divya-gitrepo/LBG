package com.example.lbg_assessment.domain.useCase

import com.example.lbg_assessment.core.common.UiState
import com.example.lbg_assessment.domain.model.ProductItem
import com.example.lbg_assessment.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(private val repository : ProductRepository)  {

    operator fun invoke() : Flow<UiState<List<ProductItem>>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(data = repository.getProductList()))
        }catch (e : Exception){
            emit(UiState.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
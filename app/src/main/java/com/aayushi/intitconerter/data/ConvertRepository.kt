package com.aayushi.intitconerter.data

import kotlinx.coroutines.flow.Flow

interface ConvertRepository {
    suspend fun insertConversionResult(conversionResult: ConversionResult)
    suspend fun deleteConversionResult(conversionResult: ConversionResult)
    suspend fun deleteAllConversionResult()
    fun getSavedResult(): Flow<List<ConversionResult>>
}
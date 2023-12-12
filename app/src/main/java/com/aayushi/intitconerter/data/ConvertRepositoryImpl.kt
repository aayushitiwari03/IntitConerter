package com.aayushi.intitconerter.data

import kotlinx.coroutines.flow.Flow

class ConvertRepositoryImpl(private val dao: ConverterDao):ConvertRepository {
    override suspend fun insertConversionResult(conversionResult: ConversionResult) {
        dao.insertConversionResult(conversionResult)
    }

    override suspend fun deleteConversionResult(conversionResult: ConversionResult) {
        dao.deleteConversionResult(conversionResult)
    }

    override suspend fun deleteAllConversionResult() {
        dao.deleteAllConversionResult()
    }

    override fun getSavedResult(): Flow<List<ConversionResult>> {
        return dao.getResult()
    }
}
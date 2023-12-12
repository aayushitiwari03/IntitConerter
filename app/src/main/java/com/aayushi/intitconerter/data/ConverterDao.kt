package com.aayushi.intitconerter.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConverterDao {

    @Insert
    suspend fun insertConversionResult(conversionResult: ConversionResult)

    @Delete
    suspend fun deleteConversionResult(conversionResult: ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun deleteAllConversionResult()

    @Query("SELECT * FROM result_table")
    fun getResult():Flow<List<ConversionResult>>
}
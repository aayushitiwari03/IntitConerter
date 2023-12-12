package com.aayushi.intitconerter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aayushi.intitconerter.data.Conversion
import com.aayushi.intitconerter.data.ConversionResult
import com.aayushi.intitconerter.data.ConvertRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConvertViewModel(
    private val repository: ConvertRepository
): ViewModel() {

    fun getConversion() = listOf(
        Conversion(1,"Pound to Kilogram","lbs","kg",0.453592),
        Conversion(2,"Kilogram to Pound","kg","lbs",2.20462),
        Conversion(3, "yards to meters","yd","m",0.9144),
        Conversion(4,"meters to yards","m","yd",1.09361),
        Conversion(5,"miles to kilometers","mi","km",1.60934),
        Conversion(6,"kilometers to miles","km","mi",0.621371),
    )

    val result = repository.getSavedResult()

    fun removeResult(conversionResult: ConversionResult){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteConversionResult(conversionResult)
        }
    }

    fun clearAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllConversionResult()
        }
    }

    fun addResult(message1:String, message2:String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertConversionResult(ConversionResult(0,message1,message2))
        }
    }
}
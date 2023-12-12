package com.aayushi.intitconerter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aayushi.intitconerter.data.ConvertRepository

class ConverterViewModelFactory(
    private val repository: ConvertRepository
):  ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ConvertViewModel(repository) as T
    }
}

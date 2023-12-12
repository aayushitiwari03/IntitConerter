package com.aayushi.intitconerter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aayushi.intitconerter.compose.history.HistoryScreen


@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier : Modifier = Modifier,
    viewModel: ConvertViewModel = viewModel(factory = factory)
) {

    val list = viewModel.getConversion()
    val historyList = viewModel.result.collectAsState(initial = emptyList())
    Column(modifier = modifier.padding(30.dp)){
        TopScreen(list){message1,message2 ->
            viewModel.addResult(message1,message2)

        }
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen(historyList,{
            viewModel.removeResult(it)
        },{
            viewModel.clearAll()
        })
    }
}
package com.aayushi.intitconerter.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.aayushi.intitconerter.data.ConversionResult

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask : (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn{
        items(
            items = list.value,
            key = {item -> item.id}

        ){
            HistoryItem(messagePart1 = it.messagePart1,
                messagePart2 = it.messagePart2,
                onClose = { onCloseTask(it) }
            )
        }
    }
}
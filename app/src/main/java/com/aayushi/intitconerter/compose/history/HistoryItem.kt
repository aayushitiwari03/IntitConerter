package com.aayushi.intitconerter.compose.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HistoryItem(
    messagePart1: String,
    messagePart2: String,
    onClose : () -> Unit,
    modifier: Modifier = Modifier
) {

        Row (
            modifier = modifier
                .fillMaxWidth()
                .border(border = BorderStroke(1.dp, Color.Black)),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ){
                Column {
                    Text(
                        text = messagePart1,
                        fontSize = 20.sp
                    )
                    Text(
                        text = messagePart2,
                        fontSize = 20.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold

                    )
                }
            
            IconButton(onClick = { onClose()}) {
                
                Icon( Icons.Filled.Close, contentDescription = "Close")
                
            }
        }
}
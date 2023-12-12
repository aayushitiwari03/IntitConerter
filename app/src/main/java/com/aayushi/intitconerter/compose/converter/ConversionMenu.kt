package com.aayushi.intitconerter


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aayushi.intitconerter.data.Conversion

@Composable
fun ConversionMenu(
    list: List<Conversion>,
    modifier : Modifier = Modifier,
    convert : (Conversion) -> Unit
) {

    var displayText by remember{ mutableStateOf("Select Conversion Type")}
    var textFieldSize by remember{ mutableStateOf(0)} //to assign the dropdown the size of the textfield
    var expand by remember{ mutableStateOf(false)} //to expand the dropdown

    val icon = if(expand)
        Icons.Filled.KeyboardArrowUp
    else  Icons.Filled.KeyboardArrowDown

    Column {


        OutlinedTextField(
            value = displayText,
            onValueChange = { displayText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    textFieldSize = it.size.width
                },
            label = { Text(text = "Conversion Type") },
            trailingIcon = {
                Icon(icon, contentDescription = "icon",
                    modifier = Modifier.clickable {
                        expand = !expand
                    })
            },
            readOnly = true
        )

        DropdownMenu(expanded = expand, onDismissRequest = { expand = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.toDp() })
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(onClick = {
                    displayText = conversion.Description
                    expand = false
                    convert(conversion)
                }) {
                    Text(
                        text = conversion.Description,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
        

}
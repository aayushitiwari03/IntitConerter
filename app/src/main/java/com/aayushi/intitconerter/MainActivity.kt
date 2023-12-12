package com.aayushi.intitconerter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aayushi.intitconerter.data.ConversionDataBase
import com.aayushi.intitconerter.data.ConvertRepository
import com.aayushi.intitconerter.data.ConvertRepositoryImpl
import com.aayushi.intitconerter.ui.theme.IntitConerterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConversionDataBase.getInstance(application).getConverterDao
        val repository = ConvertRepositoryImpl(dao)
        val factory = ConverterViewModelFactory(repository)
        setContent {
            BaseScreen(factory = factory)
        }
    }
}


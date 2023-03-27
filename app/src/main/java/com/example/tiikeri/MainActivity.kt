package com.example.tiikeri

import android.media.AudioFocusRequest
import android.os.Bundle
import android.text.InputType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiikeri.ui.theme.TiikeriTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.tiikeri.ui.theme.amatic_bold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiikeriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Eka("Peli")
                }
            }
        }
    }
}

@Composable
fun Eka(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Tiikerin vuosi",
            fontSize = 100.sp,
            color = Color.Yellow,
            textAlign = TextAlign.Center,
            fontFamily = amatic_bold
        )

        Button(
            onClick = { /* save the username */ },
            modifier = Modifier
                .height(70.dp)
                .width(200.dp)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            shape = RoundedCornerShape(25)
        ) {
            Text(
                "Pelaa", fontSize = 30.sp,
                fontFamily = amatic_bold
            )
        }
    }
}
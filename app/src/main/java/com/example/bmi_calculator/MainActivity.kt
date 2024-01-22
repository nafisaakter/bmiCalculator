package com.example.bmi_calculator

import android.os.Bundle
import android.support.v4.os.IResultReceiver2.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmi_calculator.ui.theme.Bmi_CalculatorTheme
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bmi_CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Bmi()
                }
            }
        }
    }
}

@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
fun Bmi(){
    var heightInput: String by remember {
        mutableStateOf("")
    }
    var weightInput: String by remember {
        mutableStateOf("")
    }
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight =weightInput.toIntOrNull() ?: 0
    val bmi =if(weight>0 && height>0) weight/(height*height) else 0.0
    Column(
        modifier=Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Body mass index",
            fontSize = 24.sp,

            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)

            )
        OutlinedTextField(
                value = heightInput,
        onValueChange = { heightInput = it.replace(oldChar = ',', newChar = '.') },
        label = { Text(text = "Height") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        OutlinedTextField(
            value = weightInput,
            onValueChange = { weightInput = it.replace(oldChar = ',', newChar = '.') },
            label = { Text(text = "Weight") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Text(text = stringResource(R.string.body_mass_index) + bmi)


    }
}

@Preview(showBackground = true)
@Composable
//fun GreetingPreview() {
//    Bmi_CalculatorTheme {
//        Greeting("Android")
//    }
//}
fun DefaultPreview(){
    Bmi_CalculatorTheme {
        Bmi()
    }
}
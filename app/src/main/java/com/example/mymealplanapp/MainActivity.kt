package com.example.mymealplanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var meal_time by remember {
                mutableStateOf("")
            }
            var meal_type by remember {
                mutableStateOf("")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x65D09AE0)),
            ) {
                Text(
                    text = "Welcome Hera",
                    fontWeight = FontWeight.Black,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic
                    )
Divider()
                Spacer(modifier = Modifier.size(35.dp))


                OutlinedTextField(
                    value = meal_time,
                    onValueChange = { text ->
                        meal_time = text
                    },
                    placeholder = {
                        Text(text = "Time of day",
                            fontWeight = FontWeight.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif)
                    }
                )
                Spacer(modifier = Modifier.size(40.dp))

                Row {
                    Button(onClick = {
                        meal_type = when(meal_time) {
                            "Morning" -> "Breakfast time,have some oatmeal porridge."
                            "Mid-morning" ->"Snack time, Eat some fruit"
                            "Afternoon" ->"Lunch time,have a sandwich"
                            "Mid-afternoon" ->"Have a cake for a quick bite"
                            "Dinner"->"Your main course,mince and Pasta"
                            "After-Dinner snack"->"Have Custard "
                                else -> "invalid meal time"
                        }

                    }) {
                        Text(text="Get Meal")}
                    Button(onClick = {
                        meal_time=""
                        meal_type=""
                    }) {
                        Text(text = "Reset")
                    }
                }

                Text(text = "Meal suggestion for $meal_time is:",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive)

                Text(text=meal_type)


            }
        }
    }
}


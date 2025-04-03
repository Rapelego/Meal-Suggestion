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
import androidx.compose.material3.TextField
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
//Layout of the App
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x65D09AE0)),
            ) {
                //Greetings
                Text(
                    text = "Hello Hera",
                    fontWeight = FontWeight.Black,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic
                    )
Divider()//divider line
                Spacer(modifier = Modifier.size(35.dp))

                TextField(
                    value = meal_time,
                    onValueChange = { text ->
                         meal_time = text
                    },
                    placeholder = {
                        Text(text = "Enter time of day",
                            fontWeight = FontWeight.Thin,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif)
                    }
                )//Input Field

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

                    }) //Meal suggestion button

                    { Text(text="Get Meal")}

                    Button(onClick = {
                        meal_time=""
                        meal_type=""
                    }) {
                        Text(text = "Reset")//Clear Button
                    }
                }

                Text(text = "Meal suggestion for $meal_time is:",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic)

                Text(text=meal_type,
                    fontWeight = FontWeight.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic)//Suggested meal


            }
        }
    }
}


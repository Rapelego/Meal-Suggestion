package com.example.mymealplanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

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

            Column {
                Text(text = "WELCOME HERA")

                OutlinedTextField(
                    value = meal_time,
                    onValueChange = { text ->
                        meal_time = text
                    },
                    placeholder = {
                        Text(text = "Time of day")
                    }
                )
                Row {
                    Button(onClick = {
                        meal_type = when(meal_time) {
                            "Breakfast" -> "1 cup of tea or Black coffee,Oatmeal porridge."
                            "Snack" ->"Nuts,Cheese."
                            "Lunch" ->"Toast with vegetables(onions,tomato,lettuce,etc)"
                            "Dinner" ->"Chicken Salad(chicken breast,grilled,or boiled ,with some fruits or vegetables)"
                            else -> "invalid meal time"
                        }

                    }) {
                        Text(text="Get Meal")
                    }
                    Button(onClick = {
                        meal_time=""
                        meal_type=""
                    }) {
                        Text(text = "Reset")
                    }
                }




            }
        }
    }
}


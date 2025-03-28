package com.example.mymealplanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
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
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "WELCOME HERA",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 34.sp,


                    )



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

Text(text = "Meal suggestion for $meal_time is:")
                Text(text=meal_type)


            }
        }
    }
}


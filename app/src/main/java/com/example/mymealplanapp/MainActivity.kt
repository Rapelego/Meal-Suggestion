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
            var username by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }

            Column {
                Text(text = "Meal App")


                OutlinedTextField(value = username,
                    onValueChange={text->
                        username = text

                    },
                    placeholder = {

                            Text(text = "username")
                    }
                )

                    OutlinedTextField(value = password,
                        onValueChange={text->
                            password = text

                        },
                        placeholder = {
                            Text(text= "password")
                        }
                    )

                Row {
                    Button(onClick = {/*TODO*/
                    }) {
                       Text(text = "Login")
                    }

                    Button(onClick = {/*TODO*/}) {
                        Text(text = "Exit")
                    }
                }

                Text(text = "Forgot Password")
            }
        }
    }
}


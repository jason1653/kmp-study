package org.jason.android.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jason.android.domain.LoginScreenViewModel
import org.jason.android.widget.button.PrimaryButton
import org.jason.android.widget.textfield.DefaultTextField


@Composable
fun LoginScreen() {
    val loginViewModel: LoginScreenViewModel = LoginScreenViewModel()

    val email = loginViewModel.email
    var password by remember { mutableStateOf("") }
    val emailMessage by remember { mutableStateOf("") }
    val passwordMessage by remember { mutableStateOf("") }
    val isLoading by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
        ,


    ) {
        Column(
            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    modifier = Modifier.size(20.dp),
                    onClick = {
                        println("test")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "로그인",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.W700),
                modifier = Modifier.padding(top = 30.dp)
            )

            DefaultTextField(
                label = "Email",
                titleKey = "이메일을 입력해주세요",
                secured = false,
                errorMessage = emailMessage,
                text = email,
                modifier = Modifier.padding(top = 50.dp),
                onValueChange = loginViewModel::updateEmail

            )


            DefaultTextField(
                label = "Password",
                titleKey = "패스워드를 입력해주세요",
                secured = true,
                errorMessage = passwordMessage,
                text = password,
                modifier = Modifier.padding(top = 20.dp)
            ) {
                password = it
                loginViewModel.password = it
            }


            Spacer(modifier = Modifier.weight(1f))


            PrimaryButton(
                label = "로그인",
                onClick = {
                    Log.d("TEST", "클릭")
                    loginViewModel.validateEmail()
                }
            )
        }



    }
}


@Composable
@Preview
fun PriviewLoginScreen() {
    LoginScreen()
}
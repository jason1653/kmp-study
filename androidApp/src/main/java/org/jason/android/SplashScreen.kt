package org.jason.android

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty


@Composable
fun SplashScreen() {
    val context = LocalContext.current
    var splashLoading by remember { mutableStateOf(false) }
    var logoPaddingBottom by remember { mutableStateOf(0.dp) }

    LaunchedEffect(key1 = true) {
        launch {
//            logoPaddingBottom.animateTo(targetValue = 200.dp, animationSpec = tween(durationMillis = 500))
            splashLoading = true
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.primary))) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Text(
                text = "coinbase",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = logoPaddingBottom)
            )
        }



        /*
        if (splashLoading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /* TODO: Start action */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    shape = RoundedCornerShape(3.dp)
                ) {
                    Text("시작하기", color = Color.Black)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text("로그인", color = Color.White)

                Spacer(modifier = Modifier.height(20.dp))

                Divider(color = Color.White, thickness = 1.dp)

                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { /* TODO: Kakao action */ }) {
                        Text("네이버")
                    }
                    Button(onClick = { /* TODO: Kakao action */ }) {
                        Text("카카오")
                    }
                    Button(onClick = { /* TODO: Apple action */ }) {
                        Text("애플")
                    }
                }
            }
        }

         */
    }
}



@Composable
@Preview
fun PriviewSplashScreen() {
    SplashScreen()
}
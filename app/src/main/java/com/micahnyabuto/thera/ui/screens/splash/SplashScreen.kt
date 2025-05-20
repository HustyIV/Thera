package com.micahnyabuto.thera.ui.screens.splash

import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.micahnyabuto.thera.R
import com.micahnyabuto.thera.ui.theme.SecondaryColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
){
    LaunchedEffect(Unit) {
        delay(2000)
       onSplashFinished()
    }
    Column {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(SecondaryColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.theraicon),
                contentDescription = "logo",
                modifier = Modifier.size(170.dp)
                    .clip(RoundedCornerShape(100.dp)),
                contentScale = ContentScale.Crop

            )

        }
        Spacer(Modifier.height(200.dp))

        Text("Welcome to Thera")
    }
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 200.dp),
        contentAlignment = Alignment.BottomCenter
    ){

        Text("Welcome to Thera")
    }


    Box (
        modifier = Modifier.fillMaxSize()
            .fillMaxWidth(0.4f)
            .padding(bottom = 100.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        LinearProgressIndicator()
    }



}

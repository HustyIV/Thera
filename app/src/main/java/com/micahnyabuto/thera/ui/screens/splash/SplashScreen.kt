package com.micahnyabuto.thera.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 100.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        CircularProgressIndicator()
    }

}

package com.example.tiikeri

import android.app.Activity
import android.media.MediaPlayer
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiikeri.ui.theme.amatic_bold
import kotlinx.coroutines.delay

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AnimationScreen.route) {
        composable(route = Screen.AnimationScreen.route) {
            AnimationScreen(navController = navController)
        }
        composable(route = Screen.StartScreen.route) {
            StartScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.FinalScreen.route) {
            FinalScreen(navController = navController)
        }
    }
}




@Composable
fun AnimationScreen(navController: NavController) {
    BackHandler(onBack = { /* Nappi ei toimi */ })
    val scale = remember {
        androidx.compose.animation.core.Animatable(1f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.4f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(2500L)
        navController.navigate(Screen.StartScreen.route)
    }
    Image(
        painter = painterResource(id = R.drawable.tiger2),
        contentDescription = "tiikerilogo",
        modifier = Modifier
            .fillMaxSize()
            .scale(scale.value)
    )
}





@Composable
fun StartScreen(navController: NavController) {
    BackHandler(onBack = { /* Nappi ei toimi */ })
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.tigertheme)
    }
    LaunchedEffect(Unit) {
        mediaPlayer.start()
    }
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            "Tiikerin Päivä",
            fontSize = 100.sp,
            color = Color.Yellow,
            textAlign = TextAlign.Center,
            fontFamily = amatic_bold
        )
        Button(
            onClick = { navController.navigate(Screen.MainScreen.route) },
            modifier = Modifier
                .height(70.dp)
                .width(200.dp)
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(
                "Pelaa", fontSize = 30.sp,
                fontFamily = amatic_bold
            )
        }
    }
}




@Composable
fun MainScreen(navController: NavController) {
    BackHandler(onBack = { /* Nappi ei toimi */ })
    val context = LocalContext.current
    val mediaPlayer =  remember {
        MediaPlayer.create(context, R.raw.muna,)
    }
    LaunchedEffect(Unit) {
        mediaPlayer.start()
    }
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            "CAMOON TIIKERI",
            fontSize = 75.sp,
            color = Color.Yellow,
            textAlign = TextAlign.Center,
            fontFamily = amatic_bold
        )
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(id = R.drawable.tiger),
            contentDescription = "tiikeri",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(60.dp))
        Row()
        {
            Button(
                onClick = { navController.navigate(Screen.StartScreen.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                shape = RoundedCornerShape(25.dp)
            )
            {
                Text(
                    text = "Luovutan \uD83D\uDE30",
                    fontSize = 25.sp,
                    fontFamily = amatic_bold
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = { navController.navigate(Screen.FinalScreen.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                shape = RoundedCornerShape(25.dp)
            )
            {
                Text(
                    text = "Näytä muna! \uD83D\uDE0E",
                    fontSize = 25.sp,
                    fontFamily = amatic_bold
                )
            }
        }
    }
}




@Composable
fun FinalScreen(navController: NavController) {
    BackHandler(onBack = { /* Nappi ei toimi */ })
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.win)
    }
    LaunchedEffect(Unit) {
        mediaPlayer.start()
    }
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val visible by remember { mutableStateOf(true) }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + expandIn() + expandVertically(),
            exit = shrinkOut() + fadeOut()
        ) {
            val rotation = remember { androidx.compose.animation.core.Animatable(-1000f) }
            LaunchedEffect(Unit) {
                rotation.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        durationMillis = 3000,
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tiger3),
                    contentDescription = "munatiikeri",
                    modifier = Modifier
                        .rotate(rotation.value)
                        .size(400.dp)
                )
                var showText by remember { mutableStateOf(false) }
                LaunchedEffect(true) {
                    delay(3000L)
                    showText = true
                }
                if (showText) {
                    Text(
                        text = "Voitit pelin! \uD83E\uDD73",
                        fontSize = 75.sp,
                        fontFamily = amatic_bold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Button(
                        onClick = { (context as? Activity)?.finish()},
                        modifier = Modifier.
                        padding(top = 30.dp)
                            .height(70.dp)
                            .width(200.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(text = "Poistu",
                        fontFamily = amatic_bold,
                        fontSize = 35.sp)
                    }
                }
            }
        }
    }
}
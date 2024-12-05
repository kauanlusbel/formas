package com.example.formas

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formas.ui.theme.FormasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FormasTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "splash",
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        ) {
                            composable("splash") { SplashScreen(navController) }
                            composable("inicio") { Inicio(navController) }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.iphone_14___15_pro___1),
                contentScale = ContentScale.Crop
            )
            .clickable { navController.navigate("inicio") },
        //isso serve para alinhar as coisas no centro da tela
        verticalArrangement = Arrangement.Center,
        // isso tambem serve para alinhar as imagens no centro da tela
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = painterResource(id = R.drawable.formaslaranja_1),
            contentDescription = "LOGO ",
            modifier = Modifier
                .size(300.dp)
                .offset(y = (-100).dp)

        )


    }
}

@Composable
fun Inicio(navController: NavController) {
    var email by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.iphone_14___15_pro___1),
                contentScale = ContentScale.Crop
            ),


        // isso tambem serve para alinhar as imagens no centro da tela
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(
            modifier = Modifier
                .padding(top = 50.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.formaslaranja_1),
            contentDescription = "LOGO ",
            modifier = Modifier
                .size(150.dp)

        )
        Column(
            verticalArrangement = Arrangement.Top,

            )

        {
            Spacer(
                modifier = Modifier
                    .padding(30.dp)
            )
            TextField(
                value = email,
                onValueChange = { newtext -> email = newtext },
                shape = RoundedCornerShape(25.dp),
                label = {
                    Text(text = "E-mail:")
                }

            )

            Spacer(modifier = Modifier.padding(28.dp))
            TextField(
                value = email,
                onValueChange = { newtext -> email = newtext },
                shape = RoundedCornerShape(25.dp),
                label = {
                    Text(text = "Senha:")
                }


            )
            Row {


            Text(
                text = "Cadastre-se",
                color = Color.White,
                modifier = Modifier
                    .clickable { }
                    .padding(top = 10.dp)
            )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Esqueci minha senha",
                color = Color.White,
                modifier = Modifier
                    .clickable { }
                    .padding(top = 10.dp)
                )




        }
            Button(
                onClick = { /* Ação do botão */ },
                modifier = Modifier.padding(top = 100.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFFFFEB411E),
                    fontSize = (20.sp) // Define um tamanho maior para a fonte
                )
            }


        }
    }

    }
}


@Composable
fun Login(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.iphone_14___15_pro___1),
                contentScale = ContentScale.Crop
            ),
        //isso serve para alinhar as coisas no centro da tela
        verticalArrangement = Arrangement.Center,
        // isso tambem serve para alinhar as imagens no centro da tela
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = painterResource(id = R.drawable.formaslaranja_1),
            contentDescription = "LOGO ",
            modifier = Modifier
                .size(300.dp)
                .offset(y = (-100).dp)

        )


    }
}


@Preview
@Composable
private fun splash() {
    FormasTheme {
        SplashScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInicio() {
    FormasTheme {
        Inicio(rememberNavController())
    }
}

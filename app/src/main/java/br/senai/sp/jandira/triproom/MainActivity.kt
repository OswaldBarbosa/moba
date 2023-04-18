package br.senai.sp.jandira.triproom

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.components.TopShape
import br.senai.sp.jandira.triproom.repository.UserRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")

    }

    var passwordState by remember {
        mutableStateOf("")
    }
    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            //Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TopShape()
                }

                Spacer(modifier = Modifier.height(164.dp))

                //Form
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(207, 6, 240)
                    )
                    Text(
                        text = stringResource(id = R.string.please_signin),
                        color = Color(160, 156, 156),
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(100.dp))

                    OutlinedTextField(
                        value = emailState,
                        onValueChange = {
                            emailState = it
                        },
                        label = { Text(text = stringResource(id = R.string.email)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email_24),
                                contentDescription = "",
                                tint = Color(207, 6, 240)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        value = passwordState,
                        onValueChange = {
                            passwordState = it
                        },
                        label = { Text(text = "Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        visualTransformation = if (!passwordVisibilityState) PasswordVisualTransformation() else VisualTransformation.None,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = "",
                                tint = Color(207, 6, 240)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibilityState = !passwordVisibilityState
                            }
                            ) {
                                Icon(
                                    imageVector = if (!passwordVisibilityState)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(42.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            modifier = Modifier
                                .width(134.dp)
                                .height(48.dp),
                            onClick = {
                                authenticate(emailState, passwordState, context)
                            },
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                            shape = RoundedCornerShape(16.dp)
                        )
                        {
                            Row() {
                                Text(
                                    text = stringResource(id = R.string.signin).uppercase(),
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_forward_24),
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.dont_account),
                            fontSize = 12.sp,
                            color = Color(160, 156, 156)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        TextButton(
                            onClick = {
                                var openSignup = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openSignup)
                            }
                        ) {
                            Text(
                                text = stringResource(id = R.string.signup),
                                fontSize = 12.sp,
                                color = Color(207, 6, 2540)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    BottomShape()

                }
            }
        }
    }
}

fun authenticate(
    email: String,
    password: String,
    context: Context
) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(
        email,
        password
    )

    if (user != null) {
        val openHomeActivity = Intent(context, HomeActivity::class.java)
        context.startActivity(openHomeActivity)
    }

}
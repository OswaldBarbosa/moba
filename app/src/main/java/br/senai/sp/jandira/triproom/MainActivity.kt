package br.senai.sp.jandira.triproom

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                TripRoomScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TripRoomScreen() {

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
                    Surface(
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp),
                        color = Color(207, 6, 240),
                        shape = RoundedCornerShape(bottomStart = 16.dp)
                    ) {}
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
                        value = "",
                        label = { Text(text = stringResource(id = R.string.email)) },
                        onValueChange = {},
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
                        value = " ",
                        label = { Text(text = "Password") },
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp),
                        shape = RoundedCornerShape(16.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock_24),
                                contentDescription = "",
                                tint = Color(207, 6, 240)
                            )
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
                                .height(48.dp),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                            shape = RoundedCornerShape(16.dp)
                        )
                        {
                            Row() {
                                Text(
                                    text = stringResource(id = R.string.signin).uppercase(),
                                    color = Color.White
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
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = stringResource(id = R.string.dont_account),
                            fontSize = 12.sp,
                            color = Color(160, 156, 156)
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = stringResource(id = R.string.signup),
                            fontSize = 12.sp,
                            color = Color(207, 6, 2540)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(26.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Surface(
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp),
                        color = Color(207, 6, 240),
                        shape = RoundedCornerShape(topEnd = 16.dp)
                    ) {}

                }
            }
        }
    }
}

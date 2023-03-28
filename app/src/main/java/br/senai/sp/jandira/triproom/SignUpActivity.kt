package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.components.BottomShape
import br.senai.sp.jandira.triproom.components.TopShape
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SingUpScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingUpScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.signup),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(207, 6, 240)
            )
            Text(
                text = stringResource(id = R.string.create_new_account),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
            Box() {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.Center),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(207, 6, 240),
                                Color.White
                            )
                        )
                    ),
                    backgroundColor = Color(246, 246, 246)
                ) {
                    Image(
                        modifier = Modifier
                            .padding(16.dp),
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = ""
                    )
                }
                Image(
                    modifier= Modifier
                        .size(28.dp)
                        .align(alignment = Alignment.BottomEnd),
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = ""
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = "",
                label = { Text(text = stringResource(id = R.string.username)) },
                onValueChange = {},
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24),
                        contentDescription = "",
                        tint = Color(207, 6, 240)
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = "",
                label = { Text(text = stringResource(id = R.string.phone)) },
                onValueChange = {},
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.phone_android_24),
                        contentDescription = "",
                        tint = Color(207, 6, 240)
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = "",
                label = { Text(text = stringResource(id = R.string.email)) },
                onValueChange = {},
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.email_24),
                        contentDescription = "",
                        tint = Color(207, 6, 240)
                    )
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = "",
                label = { Text(text = stringResource(id = R.string.password)) },
                onValueChange = {},
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.lock_24), contentDescription = "",
                        tint = Color(207, 6, 240)
                    )
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {}
                )
                Text(
                    text = stringResource(id = R.string.over_18),
                    fontSize = 14.sp
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                shape = RoundedCornerShape(16.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(id = R.string.create_account).uppercase(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_have_Account),
                    color = Color(160, 156, 156)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(id = R.string.signin),
                    color = Color(207, 6, 240)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BottomShape()
            }

        }
    }
}


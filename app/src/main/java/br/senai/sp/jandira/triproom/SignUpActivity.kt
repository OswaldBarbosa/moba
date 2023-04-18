package br.senai.sp.jandira.triproom

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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

    var userNameState by rememberSaveable() {
        mutableStateOf("")
    }
    var phoneState by rememberSaveable() {
        mutableStateOf("")
    }
    var emailState by rememberSaveable() {
        mutableStateOf("")
    }
    var passwordState by rememberSaveable() {
        mutableStateOf("")
    }
    var over18State by rememberSaveable() {
        mutableStateOf(false)
    }

    //obter foto da galeria de imagens

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //criar o objeto que abrirá a galeria e retornará
    //a uri da imagem selecionada
    var laucher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        photoUri = it
    }

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(photoUri).build()
    )

    var context = LocalContext.current

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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f)
        ) {

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

                Spacer(modifier = Modifier.height(26.dp))

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
                            painter = painter,
                            contentDescription = "User",
                            modifier = Modifier.size(16.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Icon(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomEnd)
                            .clickable {
                                laucher.launch("image/*")
                            },
                        painter = painterResource(id = R.drawable.camera_alt_24),
                        contentDescription = "",
                        tint = Color(207, 6, 240)
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
                    value = userNameState,
                    onValueChange = {
                        userNameState = it
                    },
                    label = { Text(text = stringResource(id = R.string.username)) },
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
                    value = phoneState,
                    onValueChange = {
                        phoneState = it
                    },
                    label = { Text(text = stringResource(id = R.string.phone)) },
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                    value = emailState,
                    onValueChange = {
                        emailState = it
                    },
                    label = { Text(text = stringResource(id = R.string.email)) },
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                    value = passwordState,
                    onValueChange = {
                        passwordState = it
                    },
                    label = { Text(text = stringResource(id = R.string.password)) },
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_24),
                            contentDescription = "",
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
                        checked = over18State,
                        onCheckedChange = {
                            over18State = it
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.over_18),
                        fontSize = 14.sp
                    )
                }

                Button(
                    onClick = {
                        userSave(
                            context,
                            emailState,
                            userNameState,
                            phoneState,
                            passwordState,
                            over18State
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    shape = RoundedCornerShape(16.dp),
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

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no banco um usuário que
    //tenha o email informado
    var user = userRepository.findUserByEmail(email)

    //Se user for null, gravamos
    //o novo usuário, senão, avisamos que o
    //usuário já existe
    if (user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            password = password,
            email = email,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context,
            "User already exist",
            Toast.LENGTH_LONG
        ).show()
    }
}


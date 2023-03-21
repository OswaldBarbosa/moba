package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen () {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.paris),
                contentDescription = "Paris"
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.End
            ) {

                Surface(
                    modifier = Modifier
                        .height(62.dp)
                        .width(62.dp),
                    shape = CircleShape
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.susanna_hoffs),
                        contentDescription = "Foto de Perfil"
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(id = R.string.name_profile),
                    color = Color.White
                )
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                
            }
        }
    }
}

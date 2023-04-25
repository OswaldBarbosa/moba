package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "",
                                tint = Color(207,6,240)
                            )
                        }
                    }
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        HomeScreen(CategoryRepository.getCategories())
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(categories: List<Category>) {

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
                contentDescription = "Paris",
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

        Text(
            modifier = Modifier
                .padding(top = 14.dp, start = 16.dp),
            text = stringResource(id = R.string.categories),
            color = Color(86, 84, 84),
            fontSize = 14.sp
        )

        LazyRow() {

            items(categories) {

                Card(
                    modifier = Modifier
                        .size(width = 130.dp, height = 100.dp)
                        .padding(top = 16.dp, start = 16.dp),
                    backgroundColor = Color(207, 6, 240)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            painter = it.icon!!,
                            contentDescription = "",
                            tint = Color.White
                        )

                        Text(
                            text = it.name,
                            fontSize = 14.sp,
                            color = Color.White
                        )

                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun defaultPreview() {
    TripRoomTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(CategoryRepository.getCategories())
        }
    }
}

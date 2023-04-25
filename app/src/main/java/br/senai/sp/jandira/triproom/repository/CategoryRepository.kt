package br.senai.sp.jandira.triproom.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    id = 1,
                    name = "Montain",
                    icon = painterResource(id = R.drawable.mountains)
                ),

                Category(
                    id = 1,
                    name = "Snow",
                    icon = painterResource(id = R.drawable.ski)
                ),

                Category(
                    id = 1,
                    name = "Beach",
                    icon = painterResource(id = R.drawable.beach)
                ),

                Category(
                    id = 1,
                    name = "Business",
                    icon = painterResource(id = R.drawable.mountains)
                )
            )
        }
    }
}
package com.a13acdhmwcustomviewandviewgroup

import androidx.annotation.DrawableRes

data class Film(
    val name: String,
    val category: String,
    val rating: Float,
    val price: Float,
    @DrawableRes val image: Int
) {
    companion object {
        val listOfFilm =
            listOf(Film("The Grinch", "Animation", 3.5F, 50.00F, R.drawable.image_movie_the_grinch))
    }
}
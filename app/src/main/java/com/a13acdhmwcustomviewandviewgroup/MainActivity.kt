package com.a13acdhmwcustomviewandviewgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a13acdhmwcustomviewandviewgroup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupListeners()
    }

    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnSetNewInfo.setOnClickListener { setNewData() }
        binding.btnGoToFun.setOnClickListener { FunActivity.start(this) }
    }

    private fun setNewData() {
        val film = Film.listOfFilm[0]
        binding.apply {
            customCardViewFirst.setTitle(film.name)
            customCardViewFirst.setCategory(film.category)
            customCardViewFirst.setRating(film.rating)
            customCardViewFirst.setPrice(film.price)
            customCardViewFirst.setImagePoster(film.image)
        }
    }
}
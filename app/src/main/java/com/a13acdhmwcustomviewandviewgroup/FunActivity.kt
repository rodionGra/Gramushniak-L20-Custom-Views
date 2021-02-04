package com.a13acdhmwcustomviewandviewgroup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a13acdhmwcustomviewandviewgroup.databinding.ActivityFunBinding

class FunActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context){
            val intent = Intent(context, FunActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityFunBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupListeners()
    }

    private fun setupBinding(){
        binding = ActivityFunBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnSpeedPlus.setOnClickListener {
            plusSpeed()
        }
        binding.btnSpeedMinus.setOnClickListener {
            minusSpeed()
        }
    }

    private fun plusSpeed(){
        binding.apply {
            rotationImg.speed++
            controlView.activeSelection = rotationImg.speed
        }
    }

    private fun minusSpeed(){
        binding.apply {
            rotationImg.speed--
            controlView.activeSelection = rotationImg.speed
        }
    }
}
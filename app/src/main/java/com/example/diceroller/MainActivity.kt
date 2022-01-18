package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView//We will declare it later on
    private lateinit var rollButton : Button

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener {
            rollDice()
        }

        mainViewModel.diceState.observe(this) { randomNum ->
            val imageResource = when(randomNum){
                1-> R.drawable.dice_1
                2-> R.drawable.dice_2
                3-> R.drawable.dice_3
                4-> R.drawable.dice_4
                5-> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(imageResource)
        }
    }

    private fun rollDice() {

        //Generate Random number
        mainViewModel.generateRandomNumber()
    }
}
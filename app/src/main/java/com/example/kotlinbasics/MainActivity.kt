package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        logging("Running onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll dice and update screen with result
     */
    private fun rollDice() {
        // Create dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update text with dice image
        val resultImageView: ImageView = findViewById(R.id.dice)
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultImageView.setImageResource(drawableResource)
        resultImageView.contentDescription = diceRoll.toString()

        // Display toast message
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
    }

    private fun logging(message: String) {
        Log.v(TAG, message)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
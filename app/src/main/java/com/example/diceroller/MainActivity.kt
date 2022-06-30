package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        rollDice()
        rollButton.setOnClickListener {
            rollDice()
            val toas = Toast.makeText(this, "Dice Rolled!!", Toast.LENGTH_SHORT)
            toas.show()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val rollval = dice.roll()
        val resultimagVie: ImageView = findViewById(R.id.imageView)
        val draw_res=when(rollval){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        resultimagVie.setImageResource(draw_res)
        resultimagVie.contentDescription=rollval.toString()
    }
}

class Dice(private val numsides: Int) {
    fun roll(): Int {
        return (1..numsides).random()
    }
}
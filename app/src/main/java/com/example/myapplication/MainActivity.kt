package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var diceImg:ImageView
    lateinit var numberText:TextView
    lateinit var nameText:TextView
    lateinit var editNameText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg=findViewById(R.id.diceImage)
        numberText=findViewById(R.id.numberText)
        editNameText=findViewById(R.id.editPlayerName)
        nameText=findViewById(R.id.playerName)
        val rollButton : Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            rollDice()
        }
        val updateBtn:Button=findViewById(R.id.updateButton)
        updateBtn.setOnClickListener{updateName(it)}
    }

    private fun updateName(view : View){
        nameText.text=editNameText.text
    }

    private fun rollDice(){
        Toast.makeText(this,"Roll!",Toast.LENGTH_SHORT).show()

        val randomNum=(1..6).random()
//        val numberText:TextView=findViewById(R.id.numberText)
        numberText.text=randomNum.toString()

//        val diceImg:ImageView=findViewById(R.id.diceImage)
        val imgSrc=when(randomNum){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        diceImg.setImageResource(imgSrc)
    }
}
package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val playerName: GameInfo = GameInfo("Ready Player One?")

    //    lateinit var diceImg: ImageView
//    lateinit var numberText: TextView
//    lateinit var nameText: TextView
//    lateinit var editNameText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.gameInfo = playerName

        binding.rollButton.setOnClickListener { rollDice() }
        binding.updateButton.setOnClickListener { updateName(it) }

//        setContentView(R.layout.activity_main)

//        diceImg = findViewById(R.id.diceImage)
//        numberText = findViewById(R.id.numberText)
//        editNameText = findViewById(R.id.editPlayerName)
//        nameText = findViewById(R.id.playerName)


//        val rollButton: Button = findViewById(R.id.rollButton)
//        rollButton.setOnClickListener {
//            rollDice()
//        }
//        val updateBtn: Button = findViewById(R.id.updateButton)
//        updateBtn.setOnClickListener { updateName(it) }


    }

    private fun updateName(view: View) {
        binding.apply {
            binding.playerName.text = binding.editPlayerName.text
            binding.playerName.clearComposingText()
            binding.editPlayerName.text.clear()
            binding.editPlayerName.clearFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun rollDice() {
        Toast.makeText(this, "Roll!", Toast.LENGTH_SHORT).show()

        val randomNum = (1..6).random()
//        val numberText:TextView=findViewById(R.id.numberText)
//        numberText.text = randomNum.toString()
        binding.numberText.text = randomNum.toString()
//        val diceImg:ImageView=findViewById(R.id.diceImage)
        val imgSrc = when (randomNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(imgSrc)
//        diceImg.setImageResource(imgSrc)
    }
}
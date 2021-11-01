package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickedBtn (view: View){
        var choosedBtn = view as Button
        var btnId = 0

        when (choosedBtn.id){
            R.id.btn1 -> btnId = 1
            R.id.btn2 -> btnId = 2
            R.id.btn3 -> btnId = 3
            R.id.btn4 -> btnId = 4
            R.id.btn5 -> btnId = 5
            R.id.btn6 -> btnId = 6
            R.id.btn7 -> btnId = 7
            R.id.btn8 -> btnId = 8
            R.id.btn9 -> btnId = 9
        }

        playGame(btnId, choosedBtn)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var unpressedBtn = ArrayList<Int>(9)
    var activePlayer = 1

    private fun playGame(btnId: Int, choosedBtn: Button) {
        activePlayer = if(activePlayer == 1){
            choosedBtn.setText("X")
            choosedBtn.setTextSize(20f)
            choosedBtn.setTextColor(Color.BLACK)
            choosedBtn.setBackgroundColor(Color.GREEN)
            player1.add(btnId)
            unpressedBtn.remove(btnId)
            2
        }else{
            choosedBtn.setText("O")
            choosedBtn.setTextSize(20f)
            choosedBtn.setTextColor(Color.BLACK)
            choosedBtn.setBackgroundColor(Color.RED)
            player2.add(btnId)
            unpressedBtn.remove(btnId)
            1
        }
        choosedBtn.isEnabled = false
        checkTheWinner(choosedBtn)
    }

    private fun checkTheWinner(choosedBtn: Button) {
        var winner = 0

        //raw 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //raw 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //raw 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner != 0){
            if (winner == 1){
                Toast.makeText(this, "player 1 is the winner", Toast.LENGTH_LONG).show()
//                disableBtn()
            }else{
                Toast.makeText(this, "player 2 is the winner", Toast.LENGTH_LONG).show()
//                disableBtn()
            }
        }

    }

//    private fun disableBtn() {
//        var arr: Array<Int> = unpressedBtn.toArray() as Array<Int>
//        for (item in arr.indices){
//            when(item){
//                1 -> {
//                    var unpressBtn1 = findViewById<Button>(R.id.btn1)
//                    unpressBtn1.isEnabled = false
//                }
//                2 -> {
//                    var unpressBtn2 = findViewById<Button>(R.id.btn2)
//                    unpressBtn2.isEnabled = false
//                }
//                3 -> {
//                    var unpressBtn3 = findViewById<Button>(R.id.btn3)
//                    unpressBtn3.isEnabled = false
//                }
//                4 -> {
//                    var unpressBtn4 = findViewById<Button>(R.id.btn4)
//                    unpressBtn4.isEnabled = false
//                }
//                5 -> {
//                    var unpressBtn5 = findViewById<Button>(R.id.btn5)
//                    unpressBtn5.isEnabled = false
//                }
//                6 -> {
//                    var unpressBtn6 = findViewById<Button>(R.id.btn6)
//                    unpressBtn6.isEnabled = false
//                }
//                7 -> {
//                    var unpressBtn7 = findViewById<Button>(R.id.btn7)
//                    unpressBtn7.isEnabled = false
//                }
//                8 -> {
//                    var unpressBtn8 = findViewById<Button>(R.id.btn8)
//                    unpressBtn8.isEnabled = false
//                }
//                9 -> {
//                    var unpressBtn9 = findViewById<Button>(R.id.btn9)
//                    unpressBtn9.isEnabled = false
//                }
//            }
//        }
//
//    }
}


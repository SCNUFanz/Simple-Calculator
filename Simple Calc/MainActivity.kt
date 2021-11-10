package com.example.calc_fanz

import com.example.calc_fanz.Calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import java.math.BigDecimal
import java.util.ArrayList
import java.util.Stack
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import java.sql.SQLOutput


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            textView.setText("")
            textView2.setText("")
            Toast.makeText(this, "Clear!", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "+"
            textView.setText(newnumber)
        }
        button3.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "-"
            textView.setText(newnumber)
        }
        button4.setOnClickListener {
            var newnumber = ""
            val currentnumber = textView.getText().toString()
            if (currentnumber.length != 0){
                for (i in 0..currentnumber.length - 2){
                    newnumber += currentnumber[i]
                }
                textView.setText(newnumber)
            }
        }
        button5.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "7"
            textView.setText(newnumber)
        }
        button6.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "8"
            textView.setText(newnumber)
        }
        button7.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "9"
            textView.setText(newnumber)
        }
        button8.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "×"
            textView.setText(newnumber)
        }
        button9.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "4"
            textView.setText(newnumber)
        }
        button10.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "5"
            textView.setText(newnumber)
        }
        button11.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "6"
            textView.setText(newnumber)
        }
        button12.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "÷"
            textView.setText(newnumber)
        }
        button13.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "1"
            textView.setText(newnumber)
        }
        button14.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "2"
            textView.setText(newnumber)
        }
        button15.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "3"
            textView.setText(newnumber)
        }
        button16.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "."
            textView.setText(newnumber)
        }
        button17.setOnClickListener {
            var tempnumber = ""
            var currentnumber = textView.getText().toString()

            for (i in 0..currentnumber.length - 1)
            {
                if (currentnumber[i] == '×')
                {
                    tempnumber += "*"
                }
                else if (currentnumber[i] == '÷')
                {
                    tempnumber += "/"
                }
                else
                {
                    tempnumber += currentnumber[i]
                }
            }
            var newnumber = Calculator.resu(tempnumber)
            textView2.setText(newnumber)
        }
        button18.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "0"
            textView.setText(newnumber)
        }
        button19.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + "("
            textView.setText(newnumber)
        }
        button20.setOnClickListener {
            val currentnumber = textView.getText().toString()
            val newnumber = currentnumber + ")"
            textView.setText(newnumber)
        }
    }
}
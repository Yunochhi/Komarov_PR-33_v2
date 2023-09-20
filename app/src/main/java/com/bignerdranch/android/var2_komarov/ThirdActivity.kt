package com.bignerdranch.android.var2_komarov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity()
{
    private lateinit var reg_buttom:Button
    private lateinit var enterNumber:TextView
    private lateinit var res:TextView
    private lateinit var from:TextView
    private lateinit var to:TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        enterNumber = findViewById(R.id.enterNumber)
        res = findViewById(R.id.res)
        reg_buttom = findViewById(R.id.buttonReg)
        from = findViewById(R.id.from)
        to= findViewById(R.id.to)
        val bytesArray = resources.getStringArray(R.array.userChose)

        val enteredDigit = intent.getLongExtra("enteredDigit",0)
        val startBytes = intent.getIntExtra("startBytes",0)
        val endBytes = intent.getIntExtra("endBytes",0)
        val result = intent.getLongExtra("result",0)

        enterNumber.text= enteredDigit.toString()
        from.text=bytesArray[startBytes].toString()
        to.text=bytesArray[endBytes].toString()
        res.text=result.toString()

        reg_buttom.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
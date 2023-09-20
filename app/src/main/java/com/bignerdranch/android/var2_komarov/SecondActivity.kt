package com.bignerdranch.android.var2_komarov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class SecondActivity : AppCompatActivity()
{
    private lateinit var spinner2: Spinner
    private lateinit var spinner1: Spinner
    private lateinit var number: EditText
    private lateinit var button_resh: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        number = findViewById(R.id.number)
        button_resh = findViewById(R.id.reshenie)
        spinner1 = findViewById(R.id.picker1)
        spinner2 = findViewById(R.id.picker2)

        val intent = Intent(this, ThirdActivity::class.java)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.userChose,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter = adapter
        spinner2.adapter = adapter

        spinner2.setSelection(2)

        button_resh.setOnClickListener()
        {

            var startBytes = spinner1.selectedItemPosition
            var endBytes = spinner2.selectedItemPosition
            var result = number.text.toString().toLong()

            intent.putExtra("startBytes", startBytes)
            intent.putExtra("endBytes", endBytes)
            intent.putExtra("enteredDigit", result)

            if (startBytes > endBytes) {
                while (startBytes != endBytes) {
                    result *= 1024
                    startBytes -= 1
                }
            } else {
                while (startBytes != endBytes) {
                    result /= 1024
                    endBytes -= 1
                }
            }
            if (number.text.toString() != "")
            {
                intent.putExtra("result", result)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Введите число", Toast.LENGTH_LONG).show()
            }
        }



    }
}
package com.bignerdranch.android.var2_komarov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity()
{
    private lateinit var buttonStart:AppCompatButton
    private lateinit var pas:EditText
    private lateinit var log:EditText
    val APP_PREFERENCES = "mysettings1"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pas = findViewById(R.id.pas)
        log = findViewById(R.id.log)
        buttonStart = findViewById(R.id.buttonStart)

        val pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        buttonStart.setOnClickListener()
        {
            if (pas.text.toString() == "" && log.text.toString() == "")
            {
                Toast.makeText(this, "Заполните поля входа!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val hasVisited = pref.getBoolean("hasVisited", false)

            if (!hasVisited) {
                val editor = pref.edit()
                editor.putBoolean("hasVisited", true)
                editor.putString("Login", log.text.toString())
                editor.putString("Password", pas.text.toString())
                editor.apply()
            }

            val sharedLogin = pref.getString("Login","")
            val sharedPassword = pref.getString("Password","")

            Log.d("pref", sharedLogin.toString())
            Log.d("pref", sharedPassword.toString())

            if(pas.text.toString() != sharedPassword || log.text.toString() != sharedLogin)
            {
                Toast.makeText(this, "Неправильный логин или пароль!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java )
            startActivity(intent)
        }
    }
}
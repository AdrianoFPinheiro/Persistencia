package com.example.adriano.persistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharePreferences = getSharedPreferences("myapp", Context.MODE_PRIVATE)

        if (sharePreferences.getBoolean("MANTER_CONECTADO", false)){
            startActivity(Intent(this, ListaGameActivity::class.java))
            finish()
        }
        btEntrar.setOnClickListener{
            val editor = sharePreferences.edit()
            editor.putBoolean("MANTER_CONECTADO", cbConectado.isChecked)
            editor.putString("USUARIO",etUsuario.text.toString())
            editor.apply()
            startActivity(Intent(this, ListaGameActivity::class.java))
            finish()
        }

    }
}

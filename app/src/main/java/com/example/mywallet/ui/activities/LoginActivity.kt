package com.example.mywallet.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mywallet.R
import com.example.mywallet.domain.Usuario
import kotlinx.android.synthetic.main.login_body.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val usuario = Usuario(id_username.text.toString(), id_password.text.toString())
            callMainActivity(usuario)
        }

        txt_cadastre_se.setOnClickListener {
            callCadastroActivity()
        }
    }

    fun callCadastroActivity() {
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }

    fun callMainActivity(usuario: Usuario) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("usuario", usuario)
        startActivity(intent)
    }
}
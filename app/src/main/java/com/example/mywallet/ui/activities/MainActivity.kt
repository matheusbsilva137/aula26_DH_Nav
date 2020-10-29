package com.example.mywallet.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mywallet.*
import com.example.mywallet.`interface`.ContractMainActivity
import com.example.mywallet.domain.Usuario
import com.example.mywallet.ui.fragments.DetailGastosFragment
import com.example.mywallet.ui.fragments.EntradasFragment
import com.example.mywallet.ui.fragments.GastosFragment
import com.example.mywallet.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractMainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Função para dar suporte para a toolbar
        setSupportActionBar(toolbar_main)

        var usuario = intent.getSerializableExtra("usuario") as? Usuario
        Toast.makeText(this, "Bem vindo, ${usuario?.username}!", Toast.LENGTH_SHORT).show()

        btn_home.setOnClickListener {
            val fragmentHome = HomeFragment.newInstance()
            callFragment(fragmentHome)
        }

        btn_entradas.setOnClickListener {
            val fragmentEntradas = EntradasFragment.newInstance()
            callFragment(fragmentEntradas)
        }

        btn_gastos.setOnClickListener {
            val fragmentGastos = GastosFragment.newInstance()
            callFragment(fragmentGastos)
        }
    }

    // Função que vai adicionar um evento aos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_main -> callProfileActivity()
        }
        return true
    }

    // Função que vai receber um Fragment e inflar ele no FrameLayout de id "id_fragment"
    fun callFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.id_fragment, fragment)
            commit()
        }
    }

    // Função que irá criar uma intent para chamar a ProfileActivity
    fun callProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("bundle", Bundle().apply {
            putString("nome", "Raul Andrade")
            putInt("idade", 19)
            putDouble("peso", 63.0)
            putString("status", "Reflexivo")
        })
        startActivity(intent)
    }

    // Função sobrescrita da interface para chamar um fragment a partir de outro fragment
    override fun callFragDetailGastos() {
        val fragmentDetailGastos = DetailGastosFragment.newInstance("Olá, mundo cruel!")

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.id_fragment_details_gastos, fragmentDetailGastos)
            addToBackStack(null)
            commit()
        }
    }

    // Função para inflar o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
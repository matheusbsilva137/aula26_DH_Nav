package com.example.mywallet.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mywallet.R
import com.example.mywallet.domain.Gasto
import kotlinx.android.synthetic.main.fragment_gastos.*
import kotlinx.android.synthetic.main.fragment_gastos.view.*

class GastosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gastos, container, false)

        view.btn_cadastrar.setOnClickListener {
            var descricao = txt_desc.text.toString()
            var categoria = txt_categoria.text.toString()
            var dataHora = txt_data_hora.text.toString()
            var valor = txt_valor.text.toString().toDouble()

            val gasto = Gasto(descricao, categoria, dataHora, valor)
        }

        return view
    }

    companion object {
        fun newInstance() = GastosFragment()
    }
}
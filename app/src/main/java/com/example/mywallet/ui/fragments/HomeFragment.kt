package com.example.mywallet.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mywallet.R
import com.example.mywallet.`interface`.ContractMainActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var contextMainActicity : ContractMainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.btn_detail_gastos.setOnClickListener {
            contextMainActicity.callFragDetailGastos()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ContractMainActivity) {
            contextMainActicity = context
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
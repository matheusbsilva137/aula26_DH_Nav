package com.example.mywallet.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mywallet.R
import com.example.mywallet.ui.activities.MainActivity

class DetailGastosFragment : Fragment() {
    var msg = ""
    private lateinit var contextMainActivity : MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_gastos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(contextMainActivity, msg, Toast.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MainActivity) contextMainActivity = context

        arguments?.getString("key")?.let {
            msg = it
        }
    }

    companion object {
        fun newInstance(msg: String) = DetailGastosFragment().apply {
            arguments = Bundle().apply {
                putString("key", msg)
            }
        }
    }
}
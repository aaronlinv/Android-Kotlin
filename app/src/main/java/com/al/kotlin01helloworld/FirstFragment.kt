package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

val MESSAGE_KEY = "MESSAGE_KEY"

class FirstFragment : Fragment() {
    private lateinit var etMessage: EditText
    private lateinit var btnAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)
        etMessage = root.findViewById(R.id.etMessage)
        btnAdd = root.findViewById(R.id.btnSend)

        val navController = findNavController()
        btnAdd.setOnClickListener {
            val bundle = bundleOf(MESSAGE_KEY to etMessage.text.toString())
            // 注意！ 这里的目的地是 my_nav_graph 中定义的 id 而非这个 Fragment 的布局 id
            navController.navigate(R.id.secondFragment2, bundle)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {
    private lateinit var btnSend: Button
    private lateinit var etMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_blank, container, false)
        btnSend = root.findViewById(R.id.buttonSend)
        etMessage = root.findViewById(R.id.editTextMessage)

        btnSend.setOnClickListener {
            val message = Bundle()
            message.putString(MESSAGE_KEY, etMessage.text.toString())
            // 通过 Activity 定义的共有方法中转
            (activity as MainActivity)?.switchFragment(SHOW_FRAGMENT, message)
        }
        return root
    }
}
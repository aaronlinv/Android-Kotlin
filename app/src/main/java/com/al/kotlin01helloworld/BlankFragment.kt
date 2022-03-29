package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {
    private lateinit var tvInfo: TextView
    private lateinit var tvArg: TextView
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_blank, container, false)
        tvInfo = root.findViewById(R.id.textViewInfo)

        val argMessage = arguments?.getString(MESSAGE_KEY) ?: "没有消息"

        tvArg = root.findViewById(R.id.textViewArg)
        // 可以在这里直接操作 UI 控件
        tvArg.text = argMessage
        return root
    }

    fun receiveMessage(message: String) {
        // 注意此方法不要直接访问 UI 控件，外部调用此方法时此 Fragment 可能还没加载到 Activity 中
        this.message = message
    }

    override fun onResume() {
        super.onResume()
        tvInfo.text = message
    }
}
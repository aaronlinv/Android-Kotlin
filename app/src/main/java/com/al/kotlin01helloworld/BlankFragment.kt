package com.al.kotlin01helloworld

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {
    private lateinit var tvInfo: TextView

    // 用于引用外部监听器对象
    private var listener: ResponseToFragmentButtonClick? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_blank, container, false)
        val btnSend = root.findViewById<Button>(R.id.buttonSend)
        var count = 0

        btnSend.setOnClickListener {
            // 回调
            listener?.responseClick(++count)
        }
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 将外部 Activity 设置为监听者
        if (context is ResponseToFragmentButtonClick) {
            listener = context
        } else {
            throw RuntimeException("$context 必须实现 ResponseToFragmentButtonClick 接口")
        }
    }

    interface ResponseToFragmentButtonClick {
        fun responseClick(clickCount: Int)
    }
}
package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BlankFragment : Fragment() {
    private lateinit var tvCount: TextView
    private lateinit var root: View
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_blank, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCount = root.findViewById(R.id.tvCount)

        viewModel = ViewModelProvider(this)
            .get(MyViewModel::class.java)

        viewModel.score.observe(viewLifecycleOwner) {
            tvCount.text = it.toString()
        }
    }
}
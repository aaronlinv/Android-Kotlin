package com.al.kotlin01helloworld

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myLog("Fragment onCreateView")
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myLog("Fragment onAttach")
    }
    // 没有这周期
    // override fun onCreate(savedInstanceState: Bundle?) {
    //
    // }

    // 已废弃，用下面的 onViewCreated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        myLog("Fragment onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myLog("Fragment onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        myLog("Fragment onStart")
    }

    override fun onStop() {
        super.onStop()
        myLog("Fragment onStop")
    }

    override fun onResume() {
        super.onResume()
        myLog("Fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        myLog("Fragment onPause")
    }

    override fun onDetach() {
        super.onDetach()
        myLog("Fragment onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        myLog("Fragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        myLog("Fragment onDestroy")
    }
}
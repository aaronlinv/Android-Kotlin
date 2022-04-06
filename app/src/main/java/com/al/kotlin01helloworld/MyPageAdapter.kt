package com.al.kotlin01helloworld

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
val NUM_PAGES = 5

class MyPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    //  负责实例化特定位置的 Fragment
    override fun createFragment(position: Int): Fragment {
        return BlankFragment(position)
    }
}
package com.example.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {

    private val fragments = mutableListOf<Fragment>()
    init {
        fragments.add(Fragment1())
        fragments.add(Fragment2())
    }

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]

}
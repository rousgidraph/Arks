package com.example.gidraph.ui.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.gidraph.ui.landing.home.home_fragment
import com.example.gidraph.ui.landing.status.status_fragment


class pagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                home_fragment()
            }
            1 -> {
                status_fragment()
            }
            else -> {
                home_fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Home"
            }
            1 -> {
                "Status"
            }
            else -> {
                "Home"
            }
        }
    }
}
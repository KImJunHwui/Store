package com.kim.store.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kim.store.fragments.ChickenStoreListFragment
import com.kim.store.fragments.PizzaStoreListFragment

class MainViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){

            1->"피자 가게"
            else->"치킨 가게"
        }

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){

            1->PizzaStoreListFragment()
            else->ChickenStoreListFragment()
        }
    }
}
package com.kim.store.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kim.store.ChickenViewDetailActivity
import com.kim.store.R
import com.kim.store.adapters.ChickenStoreListAdapter
import com.kim.store.datas.Store
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*

class ChickenStoreListFragment : Fragment() {

    val mChickenStoreList = ArrayList<Store>()

    lateinit var mChickenStoreListAdapter: ChickenStoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_chicken_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mChickenStoreList.add( Store("A치킨가게","111-2222","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MDJfOTAg%2FMDAxNjYyMTI1NzA3NDk4.Hj0ZKgefFmTCSt9obA4lPc_VH2cRnQ0pCFCR-FcnfY4g.cDt5aYbS0__Iihpi5LkGJCO3GbQIX-Y37fBh4T9FKCIg.JPEG.lloovveesss%2F20220902%25A3%25DF211346.jpg&type=a340"))
        mChickenStoreList.add( Store("B치킨가게","111-2222","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MDJfOTAg%2FMDAxNjYyMTI1NzA3NDk4.Hj0ZKgefFmTCSt9obA4lPc_VH2cRnQ0pCFCR-FcnfY4g.cDt5aYbS0__Iihpi5LkGJCO3GbQIX-Y37fBh4T9FKCIg.JPEG.lloovveesss%2F20220902%25A3%25DF211346.jpg&type=a340"))
        mChickenStoreList.add( Store("C치킨가게","111-2222","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MDJfOTAg%2FMDAxNjYyMTI1NzA3NDk4.Hj0ZKgefFmTCSt9obA4lPc_VH2cRnQ0pCFCR-FcnfY4g.cDt5aYbS0__Iihpi5LkGJCO3GbQIX-Y37fBh4T9FKCIg.JPEG.lloovveesss%2F20220902%25A3%25DF211346.jpg&type=a340"))
        mChickenStoreList.add( Store("D치킨가게","111-2222","https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MDJfOTAg%2FMDAxNjYyMTI1NzA3NDk4.Hj0ZKgefFmTCSt9obA4lPc_VH2cRnQ0pCFCR-FcnfY4g.cDt5aYbS0__Iihpi5LkGJCO3GbQIX-Y37fBh4T9FKCIg.JPEG.lloovveesss%2F20220902%25A3%25DF211346.jpg&type=a340"))

        mChickenStoreListAdapter = ChickenStoreListAdapter(requireContext(), R.layout.chicken_store_list_item, mChickenStoreList)
        chickenListView.adapter = mChickenStoreListAdapter


        chickenListView.setOnItemClickListener { parent, view, position, id ->

            val clickedChicken = mChickenStoreList[position]

            val myIntent = Intent(requireContext(), ChickenViewDetailActivity::class.java)
            myIntent.putExtra("chicken",clickedChicken)
            startActivity(myIntent)

    }
    }
}

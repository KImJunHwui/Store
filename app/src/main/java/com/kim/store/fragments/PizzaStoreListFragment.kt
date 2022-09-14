package com.kim.store.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kim.store.R
import com.kim.store.adapters.PizzaStoreListAdapter
import com.kim.store.datas.Store
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

class PizzaStoreListFragment : Fragment() {

    val mPizzaStoreList = ArrayList<Store>()

    lateinit var mPizzaStoreListAdapter: PizzaStoreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPizzaStoreList.add(Store("A피자가게","111-2222","https://th.bing.com/th/id/OIP.QG_mi3QBgiuae6rO8xQPaQHaJi?w=138&h=180&c=7&r=0&o=5&pid=1.7"))
        mPizzaStoreList.add(Store("B피자가게","111-2222","https://th.bing.com/th/id/OIP.QG_mi3QBgiuae6rO8xQPaQHaJi?w=138&h=180&c=7&r=0&o=5&pid=1.7"))
        mPizzaStoreList.add(Store("C피자가게","111-2222","https://th.bing.com/th/id/OIP.QG_mi3QBgiuae6rO8xQPaQHaJi?w=138&h=180&c=7&r=0&o=5&pid=1.7"))
        mPizzaStoreList.add(Store("D피자가게","111-2222","https://th.bing.com/th/id/OIP.QG_mi3QBgiuae6rO8xQPaQHaJi?w=138&h=180&c=7&r=0&o=5&pid=1.7"))

        mPizzaStoreListAdapter = PizzaStoreListAdapter(requireContext(), R.layout.pizza_store_list_item,mPizzaStoreList)
        pizzaListView.adapter = mPizzaStoreListAdapter



    }
}
package com.kim.store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kim.store.datas.Store
import kotlinx.android.synthetic.main.activity_chicken_view_detail.*
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*

class ChickenViewDetailActivity : BaseActivity() {

    lateinit var mClickedChicken : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chicken_view_detail)
        setUpEvents()
        setValues()
    }

    override fun setUpEvents() {

        mClickedChicken = intent.getSerializableExtra("chicken") as Store

        chickenDetailNameTxt.text = mClickedChicken.name
        chickenDetailNumTxt.text = mClickedChicken.phonNum

        Glide.with(mContext).load(mClickedChicken.imgUrl).into(chickenDetailUrlImg)


        }

    override fun setValues() {

    }

}



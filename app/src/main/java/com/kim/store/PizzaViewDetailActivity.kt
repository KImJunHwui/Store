package com.kim.store

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.kim.store.datas.Store
import kotlinx.android.synthetic.main.activity_pizza_view_detail.*

class PizzaViewDetailActivity : BaseActivity() {

    lateinit var mClickedPizza : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_view_detail)
        setUpEvents()
        setValues()
    }
    override fun setUpEvents() {

        mClickedPizza = intent.getSerializableExtra("pizza") as Store

        pizzaDetailNameTxt.text = mClickedPizza.name
        pizzaDetailNumTxt.text = mClickedPizza.phonNum

        Glide.with(mContext).load(mClickedPizza.imgUrl).into(pizzaDetailUrlImg)



    }

    override fun setValues() {


        val permission = object : PermissionListener{
            override fun onPermissionGranted() {

                pizzaDetailBtn.setOnClickListener {

                    val myUri = Uri.parse("tel:${mClickedPizza.phonNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                Toast.makeText(mContext, "[설정] 창에서 다시 확인하세요", Toast.LENGTH_SHORT).show()
            }

        }

TedPermission.create()
    .setPermissionListener(permission)
    .setDeniedMessage("[설정]창에서 다시 확인하세요")
    .setPermissions(Manifest.permission.CALL_PHONE)
    .check()



    }


}
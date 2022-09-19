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


        val permission = object : PermissionListener{
            override fun onPermissionGranted() {


                chickenDetailBtn.setOnClickListener {

                    val myUri = Uri.parse("tel:${mClickedChicken.phonNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                Toast.makeText(mContext, "[설정]에서 다시 확인 바랍니다.", Toast.LENGTH_SHORT).show()
            }




        }

        TedPermission.create()
            .setPermissionListener(permission)
            .setDeniedMessage("[설정]에서 다시 확인 바랍니다.")
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()


    }

}



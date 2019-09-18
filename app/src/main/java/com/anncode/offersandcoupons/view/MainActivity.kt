package com.anncode.offersandcoupons.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {


    private var rvCoupons: RecyclerView? = null
    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?) {

        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        activityMainBinding.setModel(couponViewModel)
        setupListUpdate()
    }

    fun setupListUpdate() {
        couponViewModel?.callCoupons()
        couponViewModel?.getCoupons()?.observe(this , Observer {
            Log.w("COUPON",it.get(0).title)
            couponViewModel?.setCouponsInRecyclerAdapter(it)
        })
    }


}

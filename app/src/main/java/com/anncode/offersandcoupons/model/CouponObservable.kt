package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable (){
    private  var couponRepository : CouponRepository = CouponReporsitoryImpl()

    fun callCoupons(){
        couponRepository.callCouponsAPI()
    }

    fun getCoupons() : MutableLiveData<List<Coupon>> {
       return  couponRepository.getCoupons()
    }
}
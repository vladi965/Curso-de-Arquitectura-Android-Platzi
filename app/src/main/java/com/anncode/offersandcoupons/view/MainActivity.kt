package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel


class MainActivity : AppCompatActivity(){

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        setupBindings(savedInstanceState)
        //VIEW

        //CallCoupons
        //getCoupons - Lista de cupones
    }
    fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)

        activityMainBinding.setModel(couponViewModel)
        setupListUpdate()
    }

    fun setupListUpdate(){
        //CallCoupons
        couponViewModel?.callCoupons()
        //getCoupons -Lista de cupones
        couponViewModel?.getCoupons()?.observe(this, Observer {
                coupons: List<Coupon> ->
            Log.w("COUPON", coupons.get(0).title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
        //ME QUEDE EN LA CLASE 24 DE CURSO DE ARQUITECTURA DE ANDROID
    }

}

package com.example.ilabanktestapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity(), BaseInterFace {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = layout
        if (layoutId != 0) {
            val binding = DataBindingUtil.setContentView(this, layoutId) as ViewDataBinding
            initUI(binding)
        }

    }


}

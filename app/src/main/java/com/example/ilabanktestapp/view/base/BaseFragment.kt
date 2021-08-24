package com.example.ilabanktestapp.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


abstract class BaseFragment : Fragment() {

    private lateinit var binding: ViewDataBinding

    abstract fun getLayoutId(): Int

    abstract fun onViewsInitialized(binding: ViewDataBinding, view: View)

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }


    open fun switchToPage(@IdRes actionID: Int) {
        NavHostFragment.findNavController(this).navigate(actionID)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewsInitialized(binding, view)
        super.onViewCreated(view, savedInstanceState)
    }

    fun finish() {
        (activity as BaseActivity).finish()
    }


}
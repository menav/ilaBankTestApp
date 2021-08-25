package com.example.ilabanktestapp.ui.splash

import android.view.View
import androidx.databinding.ViewDataBinding
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.FragmentSplashBinding
import com.example.ilabanktestapp.utils.Constant.Companion.SPLASH_DELAY
import com.example.ilabanktestapp.ui.base.BaseActivity
import com.example.ilabanktestapp.ui.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {


    private lateinit var mSplashBinding: FragmentSplashBinding
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash

    }

    override fun onViewsInitialized(binding: ViewDataBinding, view: View) {
        mSplashBinding = binding as FragmentSplashBinding
    }

    override fun onResume() {
        super.onResume()
        (activity as BaseActivity).supportActionBar?.hide()
        moveToHomePage()
    }

    private fun moveToHomePage() {
        mainScope.launch {
            mSplashBinding.ivLogo.postDelayed({
                switchToPage(R.id.action_splash_to_dashboardFragment)
            }, SPLASH_DELAY)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
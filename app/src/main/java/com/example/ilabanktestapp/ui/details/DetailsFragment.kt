package com.example.ilabanktestapp.ui.details

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.viewpager.widget.ViewPager
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.FragmentDetailsBinding
import com.example.ilabanktestapp.utils.TextAfterChange
import com.example.ilabanktestapp.ui.base.BaseFragment
import com.example.ilabanktestapp.ui.main.MainActivity
import com.example.ilabanktestapp.utils.gone
import com.example.ilabanktestapp.utils.hideKeyboard
import com.example.ilabanktestapp.utils.visible
import com.example.ilabanktestapp.viewmodels.DetailsViewModel


class DetailsFragment : BaseFragment() {


    private lateinit var mViewBinding: FragmentDetailsBinding
    private lateinit var dashboardRecyclerAdapter: DashboardRecyclerAdapter
    private lateinit var detailsViewPagerAdapter: DetailsViewPagerAdapter
    private val mViewModel: DetailsViewModel by activityViewModels()

    override fun getLayoutId(): Int {
        return R.layout.fragment_details
    }

    override fun onViewsInitialized(binding: ViewDataBinding, view: View) {
        mViewBinding = binding as FragmentDetailsBinding
        setListeners()
        setObservers()
        setViewPager()
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).supportActionBar?.show()
    }


    private fun setViewPager() {
        detailsViewPagerAdapter = DetailsViewPagerAdapter()
        mViewBinding.vpCarousel.adapter = detailsViewPagerAdapter
        mViewBinding.tlBottomDots.setupWithViewPager(mViewBinding.vpCarousel, true)
    }


    private fun setRecyclerView() {
        mViewModel.postDataToCarousel(mViewModel.getDataWithRespectToPosition(0))
        dashboardRecyclerAdapter = DashboardRecyclerAdapter {
            if (it) {
                mViewBinding.emptyView.visible()
            } else {
                mViewBinding.emptyView.gone()
            }
        }
        mViewBinding.rvCarousel.run {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = dashboardRecyclerAdapter
        }

    }


    private fun setListeners() {
        mViewBinding.vpCarousel.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                mViewModel.postDataToCarousel(
                    mViewModel.getDataWithRespectToPosition(
                        position
                    )
                )
            }
        })

        mViewBinding.etSearch.addTextChangedListener(TextAfterChange {
            dashboardRecyclerAdapter.filter.filter(it)
        })
        mViewBinding.etSearch.setOnClickListener {
            mViewBinding.rootMotionLayout.transitionToEnd()
            mViewBinding.rootMotionLayout.requestFocus()
        }
        mViewBinding.etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                mViewBinding.etSearch.hideKeyboard()
                return@OnEditorActionListener true
            }
            false
        })
        mViewBinding.etSearch.setOnFocusChangeListener { v, hasFocus ->
            run {
                if (hasFocus) {
                    mViewBinding.rootMotionLayout.transitionToEnd()
                }
            }
        }


    }


    private fun setObservers() {
        mViewModel.carouselImageData.observe(viewLifecycleOwner, {
            detailsViewPagerAdapter.addItems(it)
        })

        mViewModel.selectedCarouselImageListData.observe(viewLifecycleOwner, {
            dashboardRecyclerAdapter.setOriginalList(it)
        })
    }

}
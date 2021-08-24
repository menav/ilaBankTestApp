package com.example.ilabanktestapp.view.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.ItemCarouselBinding
import com.example.ilabanktestapp.model.CarouselData


class DashboardViewPagerAdapter : PagerAdapter() {

    var dataList: List<CarouselData> = arrayListOf()

    override fun isViewFromObject(view: View, Object: Any): Boolean {
        return view === Object as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<ItemCarouselBinding>(
            LayoutInflater.from(container.context),
            R.layout.item_carousel,
            container,
            false
        )

        binding.ivCarousalImage.setImageResource(dataList[position].carouselImage)
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int = dataList.size

    override fun destroyItem(container: ViewGroup, position: Int, Object: Any) {
        container.removeView(Object as ConstraintLayout)
    }


    fun addItems(list: List<CarouselData>) {
        dataList = list
        notifyDataSetChanged()
    }
}
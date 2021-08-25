package com.example.ilabanktestapp.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.ItemCarouselBinding
import com.example.ilabanktestapp.data.model.CarouselImageData


class DetailsViewPagerAdapter : PagerAdapter() {

    var imageDataList: List<CarouselImageData> = arrayListOf()

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

        binding.ivCarousalImage.setImageResource(imageDataList[position].carouselImage)
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int = imageDataList.size

    override fun destroyItem(container: ViewGroup, position: Int, Object: Any) {
        container.removeView(Object as ConstraintLayout)
    }


    fun addItems(list: List<CarouselImageData>) {
        imageDataList = list
        notifyDataSetChanged()
    }
}
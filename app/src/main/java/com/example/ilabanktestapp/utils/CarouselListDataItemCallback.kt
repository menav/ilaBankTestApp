package com.example.ilabanktestapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.ilabanktestapp.data.model.CarouselImageListData

class CarouselListDataItemCallback : DiffUtil.ItemCallback<CarouselImageListData>() {
    override fun areItemsTheSame(
        oldItem: CarouselImageListData,
        newItem: CarouselImageListData
    ): Boolean {
        return oldItem.carouselDataId == newItem.carouselDataId
    }

    override fun areContentsTheSame(
        oldItem: CarouselImageListData,
        newItem: CarouselImageListData
    ): Boolean {
        return oldItem == newItem
    }
}
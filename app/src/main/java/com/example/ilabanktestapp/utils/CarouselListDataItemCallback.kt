package com.example.ilabanktestapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.ilabanktestapp.model.CarouselListData

class CarouselListDataItemCallback : DiffUtil.ItemCallback<CarouselListData>() {
    override fun areItemsTheSame(
        oldItem: CarouselListData,
        newItem: CarouselListData
    ): Boolean {
        return oldItem.carouselDataId == newItem.carouselDataId
    }

    override fun areContentsTheSame(
        oldItem: CarouselListData,
        newItem: CarouselListData
    ): Boolean {
        return oldItem == newItem
    }
}
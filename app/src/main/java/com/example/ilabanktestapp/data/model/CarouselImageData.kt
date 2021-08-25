package com.example.ilabanktestapp.data.model

import androidx.annotation.DrawableRes

data class CarouselImageData(
        val carouselId: Int,
        @DrawableRes val carouselImage: Int,
        val data: List<CarouselImageListData>
)
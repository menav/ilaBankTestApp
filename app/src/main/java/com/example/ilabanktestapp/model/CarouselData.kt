package com.example.ilabanktestapp.model

import androidx.annotation.DrawableRes

data class CarouselData(
        val carouselId: Int,
        @DrawableRes val carouselImage: Int,
        val data: List<CarouselListData>
)
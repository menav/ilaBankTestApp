package com.example.ilabanktestapp.model

import androidx.annotation.DrawableRes

data class CarouselListData(
    val id: Int,
    val carouselDataId: Int,
    @DrawableRes val image: Int,
    val label: String
)
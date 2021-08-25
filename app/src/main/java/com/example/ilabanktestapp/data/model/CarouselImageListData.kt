package com.example.ilabanktestapp.data.model

import androidx.annotation.DrawableRes

data class CarouselImageListData(
    val id: Int,
    val carouselDataId: Int,
    @DrawableRes val image: Int,
    val label: String
)
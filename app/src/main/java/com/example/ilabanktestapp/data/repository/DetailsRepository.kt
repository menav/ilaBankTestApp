package com.example.ilabanktestapp.data.repository

import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.data.model.CarouselImageData
import com.example.ilabanktestapp.data.model.CarouselImageListData

class DetailsRepository {

    private val data = mutableListOf<CarouselImageData>()


    /*add dynamic value on carousel */
    fun generateDynamicCarouselData(
        carouselCount: Int = 1,
        carouselItemCount: Int = 1
    ): List<CarouselImageData> {
        data.clear()
        for (i in 1..carouselCount) {
            val tempCarouseItem = mutableListOf<CarouselImageListData>()
            for (j in 1..carouselItemCount) {
                tempCarouseItem.add(
                    CarouselImageListData(
                        id = i,
                        carouselDataId = j,
                        image = R.drawable.ic_balance,
                        label = "Balance ${i.times(10).plus(j)}"
                    )
                )
            }
            data.add(
                CarouselImageData(
                    carouselId = i,
                    carouselImage = R.mipmap.ic_screen,
                    data = tempCarouseItem
                )
            )
        }

        return data
    }

}
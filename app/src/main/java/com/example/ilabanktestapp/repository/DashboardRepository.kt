package com.example.ilabanktestapp.repository

import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.model.CarouselData
import com.example.ilabanktestapp.model.CarouselListData

class DashboardRepository {

    private val data = mutableListOf<CarouselData>()

    fun generateDynamicCarouselData(
        carouselCount: Int = 1,
        carouselItemCount: Int = 1
    ): List<CarouselData> {
        data.clear()
        for (i in 1..carouselCount) {
            val tempCarouseItem = mutableListOf<CarouselListData>()
            for (j in 1..carouselItemCount) {
                tempCarouseItem.add(
                    CarouselListData(
                        id = i,
                        carouselDataId = j,
                        image = R.drawable.ic_balance,
                        label = "Balance ${i.times(10).plus(j)}"
                    )
                )
            }
            data.add(
                CarouselData(
                    carouselId = i,
                    carouselImage = R.mipmap.ic_screen,
                    data = tempCarouseItem
                )
            )
        }

        return data
    }

}
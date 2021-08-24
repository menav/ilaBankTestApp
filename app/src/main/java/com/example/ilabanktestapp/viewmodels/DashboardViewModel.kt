package com.example.ilabanktestapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ilabanktestapp.repository.DashboardRepository
import com.example.ilabanktestapp.model.CarouselData
import com.example.ilabanktestapp.model.CarouselListData
import com.example.ilabanktestapp.utils.Constant.Companion.CAROUSEL_DATA_COUNT
import com.example.ilabanktestapp.utils.Constant.Companion.CAROUSEL_ITEM_DATA_COUNT

class DashboardViewModel : ViewModel() {


    private val repository = DashboardRepository()

    private val mCarouselData = MutableLiveData<List<CarouselData>>()
    val carouselData: LiveData<List<CarouselData>> = mCarouselData

    private val mSelectedCarouselListData = MutableLiveData<List<CarouselListData>>()

    val selectedCarouselListData: LiveData<List<CarouselListData>> = mSelectedCarouselListData


    init {
        mCarouselData.value = repository.generateDynamicCarouselData(CAROUSEL_DATA_COUNT, CAROUSEL_ITEM_DATA_COUNT)
    }

    fun postDataToCarousel(carouselListData: List<CarouselListData>) {
        mSelectedCarouselListData.value=carouselListData
    }

    fun getDataWithRespectToPosition(position: Int): List<CarouselListData> {
        return mCarouselData.value?.get(position)?.data ?: listOf()
    }
}
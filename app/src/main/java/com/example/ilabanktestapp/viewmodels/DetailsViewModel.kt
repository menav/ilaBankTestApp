package com.example.ilabanktestapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ilabanktestapp.data.repository.DetailsRepository
import com.example.ilabanktestapp.data.model.CarouselImageData
import com.example.ilabanktestapp.data.model.CarouselImageListData
import com.example.ilabanktestapp.utils.Constant.Companion.CAROUSEL_DATA_COUNT
import com.example.ilabanktestapp.utils.Constant.Companion.CAROUSEL_ITEM_DATA_COUNT

class DetailsViewModel : ViewModel() {


    private val repository = DetailsRepository()

    private val mCarouselData = MutableLiveData<List<CarouselImageData>>()
    val carouselImageData: LiveData<List<CarouselImageData>> = mCarouselData

    private val mSelectedCarouselListData = MutableLiveData<List<CarouselImageListData>>()

    val selectedCarouselImageListData: LiveData<List<CarouselImageListData>> = mSelectedCarouselListData


    init {
        mCarouselData.value = repository.generateDynamicCarouselData(CAROUSEL_DATA_COUNT, CAROUSEL_ITEM_DATA_COUNT)
    }

    fun postDataToCarousel(carouselImageListData: List<CarouselImageListData>) {
        mSelectedCarouselListData.value=carouselImageListData
    }

    fun getDataWithRespectToPosition(position: Int): List<CarouselImageListData> {
        return mCarouselData.value?.get(position)?.data ?: listOf()
    }
}
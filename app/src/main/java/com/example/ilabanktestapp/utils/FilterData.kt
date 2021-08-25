package com.example.ilabanktestapp.utils

import android.widget.Filter
import com.example.ilabanktestapp.data.model.CarouselImageListData

class FilterData<T>(
    private val dataImageList: List<CarouselImageListData>,
    val onFilter: (List<T>) -> Unit
) : Filter() {
    override fun performFiltering(ch: CharSequence?): FilterResults {
        var filteredList = mutableListOf<CarouselImageListData>()

        if (ch.isNullOrEmpty()) {
            filteredList = dataImageList.toMutableList()
        } else {
            for (i in dataImageList) {
                if (i.label.contains(ch, ignoreCase = true))
                    filteredList.add(i)
            }
        }
        return FilterResults().apply { values = filteredList }
    }

    override fun publishResults(ch: CharSequence?, p1: FilterResults?) {
        try {
            onFilter(p1?.values as List<T>)
        } catch (e: Exception) {
            onFilter(listOf())
        }
    }

}
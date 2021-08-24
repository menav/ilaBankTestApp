package com.example.ilabanktestapp.utils

import android.widget.Filter
import com.example.ilabanktestapp.model.CarouselListData

class FilterData<T>(
    private val dataList: List<CarouselListData>,
    val onFilter: (List<T>) -> Unit
) : Filter() {
    override fun performFiltering(ch: CharSequence?): FilterResults {
        var filteredList = mutableListOf<CarouselListData>()

        if (ch.isNullOrEmpty()) {
            filteredList = dataList.toMutableList()
        } else {
            for (i in dataList) {
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
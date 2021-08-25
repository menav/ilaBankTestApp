package com.example.ilabanktestapp.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.ItemCarouselListBinding
import com.example.ilabanktestapp.data.model.CarouselImageListData
import com.example.ilabanktestapp.utils.CarouselListDataItemCallback
import com.example.ilabanktestapp.utils.FilterData

class DashboardRecyclerAdapter(val showEmptyView: (Boolean) -> Unit) :
    ListAdapter<CarouselImageListData, DashboardRecyclerAdapter.DashboardRecyclerViewHolder>(
        CarouselListDataItemCallback()
    ),
    Filterable {

    var dataList = listOf<CarouselImageListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardRecyclerViewHolder {
        val binding = DataBindingUtil.inflate<ItemCarouselListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_carousel_list,
            parent,
            false
        )
        return DashboardRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    fun setOriginalList(data: List<CarouselImageListData>) {
        dataList = data
        submitList(data)
    }

    class DashboardRecyclerViewHolder(private val mBinding: ItemCarouselListBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(carouselImageListItemData: CarouselImageListData) {
            mBinding.carouseListItemData = carouselImageListItemData
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return FilterData<CarouselImageListData>(dataList) {
            submitList(it)
            showEmptyView(it.isNullOrEmpty())
        }
    }
}


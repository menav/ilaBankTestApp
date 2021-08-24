package com.example.ilabanktestapp.view.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ilabanktestapp.R
import com.example.ilabanktestapp.databinding.ItemCarouselListBinding
import com.example.ilabanktestapp.model.CarouselListData
import com.example.ilabanktestapp.utils.CarouselListDataItemCallback
import com.example.ilabanktestapp.utils.FilterData


class DashboardRecyclerAdapter(val showEmptyView: (Boolean) -> Unit) :
    ListAdapter<CarouselListData, DashboardRecyclerAdapter.DashboardRecyclerViewHolder>(
        CarouselListDataItemCallback()
    ),
    Filterable {

    var dataList = listOf<CarouselListData>()

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


    fun setOriginalList(data: List<CarouselListData>) {
        dataList = data
        submitList(data)
    }

    class DashboardRecyclerViewHolder(private val mBinding: ItemCarouselListBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(carouselListItemData: CarouselListData) {
            mBinding.carouseListItemData = carouselListItemData
            mBinding.executePendingBindings()
        }
    }

    override fun getFilter(): Filter {
        return FilterData<CarouselListData>(dataList) {
            submitList(it)
            showEmptyView(it.isNullOrEmpty())
        }
    }
}


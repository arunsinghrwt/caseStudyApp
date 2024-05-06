package com.target.targetcasestudy.ui.deals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.target.targetcasestudy.databinding.DealListItemBinding
import com.target.targetcasestudy.network.data.Deal
import javax.inject.Inject


class DealItemAdapter @Inject constructor() :
    ListAdapter<Deal, DealItemAdapter.DealsViewHolder>(callback) {


    internal var clickListener: (id: Int) -> Unit = { id: Int ->  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
        return DealsViewHolder(
            DealListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class DealsViewHolder(val binding: DealListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Deal,
            clickListener: (model: Int) -> Unit
        ) = with(binding) {

            tvDealPrice.text = if (item.salePrice?.displayString != null) item.salePrice.displayString else item.regularPrice?.displayString
            tvDealRegPrice.text = item.regularPrice?.displayString
            tvFulfillment.text = item.fulfillment
            tvProductTittle.text = item.title
            tvAvailability.text = item.availability
            tvAisle.text = item.aisle
            Glide.with(ivDeal.context)
                .load(item.imageUrl)
                .into(ivDeal)

            itemView.setOnClickListener()
            {
                item.id?.toInt()?.let { it1 -> clickListener.invoke(it1) }
            }


        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<Deal>() {
            override fun areItemsTheSame(oldItem: Deal, newItem: Deal) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Deal, newItem: Deal
            ) = oldItem == newItem
        }
    }

}
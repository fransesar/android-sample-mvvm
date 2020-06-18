package com.example.mvvm.ui.dogslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.BR
import com.example.mvvm.R
import com.example.mvvm.data.Dogs

class DogsAdapter : ListAdapter<Dogs, DogsAdapter.DogsViewHolder>(BlockDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
        return DogsViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int): Int = R.layout.item_dogs

    class DogsViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dogs: Dogs) {
            binding.setVariable(BR.dogs, dogs)
            binding.executePendingBindings()
        }
    }

    object BlockDiff : DiffUtil.ItemCallback<Dogs>() {
        override fun areItemsTheSame(oldItem: Dogs, newItem: Dogs): Boolean {
            return oldItem.dogsName == newItem.dogsName && oldItem.dogsImage == newItem.dogsImage
        }

        override fun areContentsTheSame(oldItem: Dogs, newItem: Dogs) = oldItem == newItem
    }
}
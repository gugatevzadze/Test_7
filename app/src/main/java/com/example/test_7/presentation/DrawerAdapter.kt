package com.example.test_7.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_7.databinding.ListItemLayoutBinding
import com.example.test_7.presentation.model.NavigationItemModel

class DrawerAdapter: ListAdapter<NavigationItemModel, DrawerAdapter.ViewHolder>(NavigationItemModelDiffCallback()) {


    inner class ViewHolder(private val binding: ListItemLayoutBinding ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: NavigationItemModel){
            with(binding) {
                itemIcon.setImageResource(item.icon)
                itemTitle.text = item.title
                itemNotifications.text = item.notifications?.toString()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val navigationItemModel = getItem(position)
        holder.bind(navigationItemModel)
    }

    class NavigationItemModelDiffCallback : DiffUtil.ItemCallback<NavigationItemModel>() {
        override fun areItemsTheSame(oldItem: NavigationItemModel, newItem: NavigationItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NavigationItemModel, newItem: NavigationItemModel): Boolean {
            return oldItem == newItem
        }
    }
}
package com.irv205.xmlwithcompose.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irv205.xmlwithcompose.core.utils.CharacterDiffCallback
import com.irv205.xmlwithcompose.core.utils.setGlideImage
import com.irv205.xmlwithcompose.databinding.ComposableItemListBinding
import com.irv205.xmlwithcompose.databinding.ItemListBinding
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.presentation.main.ItemCard

class MainAdapterXML :
    ListAdapter<CharacterDomain, MainAdapterXML.ViewHolder>(CharacterDiffCallback) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ComposableItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ComposableItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: CharacterDomain){
//            binding.apply {
//                tvNameItem.text = item.name
//                tvNumberItem.text = item.id.toString()
//                tvStatusItem.text = item.status
//                tvDesItem.text = item.species
//                ivItem.setGlideImage(item.image)
//            }
            binding.composeView.setContent {

                ItemCard(characterDomain = item)
            }
        }
    }
}
package com.irv205.xmlwithcompose.core.utils

import androidx.recyclerview.widget.DiffUtil
import com.irv205.xmlwithcompose.domain.model.CharacterDomain

object CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDomain>() {
    override fun areItemsTheSame(oldItem: CharacterDomain, newItem: CharacterDomain): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CharacterDomain, newItem: CharacterDomain): Boolean {
        return oldItem == newItem
    }
}
package com.irv205.xmlwithcompose.presentation.main.adapter

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.irv205.xmlwithcompose.domain.model.CharacterDomain
import com.irv205.xmlwithcompose.presentation.main.ItemCard

class MyComposeAdapter :
    RecyclerView.Adapter<MyComposeAdapter.MyComposeViewHolder2>(){

    var items = emptyList<CharacterDomain>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyComposeViewHolder2 {
        return MyComposeViewHolder2(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: MyComposeViewHolder2, position: Int) {
        holder.bind(items[position])
    }

    override fun onViewRecycled(holder: MyComposeViewHolder2) {
        holder.composeView.disposeComposition()
    }

    inner class MyComposeViewHolder2(val composeView: ComposeView): RecyclerView.ViewHolder(composeView){
        fun bind(item: CharacterDomain) {
            composeView.setContent {
                ItemCard(characterDomain = item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

}

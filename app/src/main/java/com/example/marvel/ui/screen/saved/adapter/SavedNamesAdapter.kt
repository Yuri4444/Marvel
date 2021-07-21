package com.example.marvel.ui.screen.saved.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.data.db.SearchedNames
import kotlinx.android.synthetic.main.item_saved.view.*
import java.util.ArrayList

class SavedNamesAdapter : RecyclerView.Adapter<SavedNamesAdapter.ViewHolder>() {

    private val list: MutableList<SearchedNames> = ArrayList()

    fun setData(newList: List<SearchedNames>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNamesAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_saved, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedNamesAdapter.ViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(searchedNames: SearchedNames) {
            itemView.tvId.text = searchedNames.id.toString()
            itemView.tvName.text = searchedNames.name
        }
    }
}
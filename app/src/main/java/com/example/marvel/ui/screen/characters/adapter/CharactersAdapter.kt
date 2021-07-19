package com.example.marvel.ui.screen.characters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.data.network.model.HeroesList
import kotlinx.android.synthetic.main.item_characters.view.*
import java.util.*

class CharactersAdapter(private val context: Context) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private val list: MutableList<HeroesList> = ArrayList()

    fun setData(newList: List<HeroesList>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharactersAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_characters, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersAdapter.ViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(results: HeroesList) {
//            Glide.with(context).load("https://cdn.cloudflare.steamstatic.com${results.image}")
            Glide.with(context).load(results.image)
                .into(itemView.ivImage)
            itemView.tvName.text = results.name
        }
    }
}
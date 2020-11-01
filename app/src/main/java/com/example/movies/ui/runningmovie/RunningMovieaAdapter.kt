package com.example.movies.ui.runningmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.NowPlayingModel
import com.example.movies.databinding.ItemDataBinding

class RunningMovieaAdapter(
    items: List<NowPlayingModel.Result>,
    private val itemClick: (view: View, position: Int, nowPlayingModel: NowPlayingModel.Result?) -> Unit
) :
    RecyclerView.Adapter<RunningMovieaAdapter.ViewHolder>() {

    // refresh items
    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_data,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener(holder)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    inner class ViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            v?.let {
                itemClick.invoke(it, adapterPosition, items[adapterPosition])
            }
        }

        fun bind(
            position: Int
        ) {
            binding.playing = items[position]
            binding.executePendingBindings()
        }
    }
}

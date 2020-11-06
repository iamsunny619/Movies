package com.example.movies.ui.runningmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.movies.R
import com.example.movies.data.nowplaying.NowPlayingModel
import com.example.movies.databinding.ItemDataBinding

class RunningMoviePagingAdapter :
    PagingDataAdapter<NowPlayingModel.Result, RunningMoviePagingAdapter.MyViewHolder>(
        DATA_COMPARATOR
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class MyViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NowPlayingModel.Result) {
            binding.apply {
                Glide.with(itemView)
                    .load(data.posterPath)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_baseline_error_24)
                    .into(imgMovie)
                txtMovieName.text = data.originalTitle
            }
        }
    }

    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<NowPlayingModel.Result>() {
            override fun areItemsTheSame(
                oldItem: NowPlayingModel.Result,
                newItem: NowPlayingModel.Result
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: NowPlayingModel.Result,
                newItem: NowPlayingModel.Result
            ) = oldItem == newItem
        }
    }
}
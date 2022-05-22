package com.ashish.movielist.ui.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashish.movielist.databinding.MovieItemViewBinding
import com.ashish.movielist.model.Card
import com.bumptech.glide.Glide

class MovieListAdapter(cardListItem: List<Card>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var cardArrayList = ArrayList<Card>()

    private lateinit var mContext: Context

    class CountryHolder(var viewBinding: MovieItemViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    init {
        cardArrayList = cardListItem as ArrayList<Card>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            MovieItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        val sch = CountryHolder(binding)
        mContext = parent.context
        return sch
    }

    override fun getItemCount(): Int {
        return cardArrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val countryHolder = holder as CountryHolder
        countryHolder.viewBinding.apply {
            with(cardArrayList[position]) {
                movieNameText.text = (content.title)
                Glide.with(mContext).load(content.movie_logo).into(movieLogo)
            }
        }
    }
}

package com.example.seirin.TourAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seirin.Model.Places
import com.example.seirin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tour_rv_layout.view.*

class TourAdapter(val context: Context?, private val places: ArrayList<Places>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.tour_rv_layout, parent, false  )
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // now we bind view and data here

        Picasso.get().load(places[position].url).into(holder.itemView.Tourimage)

        //Start Kenburns goes here
        holder.itemView.Tourimage.resume()

        holder.itemView.TourTitle.text=places[position].title
        holder.itemView.TourDescription.text=places[position].description
        holder.itemView.Ratingbar.rating=places[position].rating!!
    }
        class ViewHolder(v:View?):RecyclerView.ViewHolder(v!!), View.OnClickListener {
            override fun onClick(v: View?) {
            }


            init{
                itemView.setOnClickListener(this)

        }



        }
    }



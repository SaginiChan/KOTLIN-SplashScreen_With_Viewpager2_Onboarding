package com.example.seirin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IntroSliderAdapter(private  val introSlides:List<IntroSlide>):RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {

        return IntroSlideViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slide_iteem_container,parent,false ))
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val textTitle =view.findViewById<TextView>(R.id.TextTitle)
        private val textDescription =view.findViewById<TextView>(R.id.TextDescription)
        private val textImageIcon =view.findViewById<ImageView>(R.id.ImageSlideIcon)

      fun  bind(IntroSlide: IntroSlide){

          textTitle.text =IntroSlide.title
          textDescription.text=IntroSlide.description
          textImageIcon.setImageResource(IntroSlide.icon)
      }
    }


}
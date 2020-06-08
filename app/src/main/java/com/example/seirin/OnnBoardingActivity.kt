package com.example.seirin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_onn_boarding.*

class OnnBoardingActivity : AppCompatActivity() {

    private val introSliderAdapter =IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Sunlight",
                "Ghost Vs Zombie Vs Vampire Vs Werewolf", +
                R.drawable.pen
            ),
            IntroSlide(
                "Pay Online",
                "Hell Yeah",
                R.drawable.books1
            ),
            IntroSlide(
                "Video Streaming Made Easier Bitch",
                "Drake sucks",
                R.drawable.class1
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onn_boarding)
        IntroSliderViewPager.adapter =introSliderAdapter
        setupindicators()
        setcurrentIndicator(0)
        IntroSliderViewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setcurrentIndicator(position)
            }
        })
        buttonnext.setOnClickListener{
        if    (IntroSliderViewPager.currentItem +1 < introSliderAdapter.itemCount){
                IntroSliderViewPager.currentItem +=1
        }else {

            Intent(applicationContext,MainActivity::class.java).also{
                startActivity(it)

            }
        }

        }
        Textskip.setOnClickListener {


        }
    }
    private fun setupindicators() {

        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount )
        val layoutParams :LinearLayout.LayoutParams =LinearLayout.LayoutParams(WRAP_CONTENT,
            WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){

             indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams =layoutParams
            }
            indicatorscontainer.addView(indicators[i])
        }
    }
    private fun setcurrentIndicator(index : Int) {
        val childCount =indicatorscontainer.childCount
        for (i in 0 until childCount){

            val imageView =indicatorscontainer[i]as ImageView
            if (i== index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    ))
            }
        }
    }
}

package com.example.seirin



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.seirin.CustomZoom.CenterZoomLayout
import com.example.seirin.Model.Places
import com.example.seirin.TourAdapter.TourAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initiate views
        val toursRV =findViewById<RecyclerView>(R.id.tourRV)

        //initiate layout manage here
        val layoutManager = CenterZoomLayout(this)

        layoutManager.orientation =LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout=true
        layoutManager.stackFromEnd=true
        toursRV.layoutManager =layoutManager


        //to auto center views
        val  snapHelper =LinearSnapHelper ()
        snapHelper.attachToRecyclerView(toursRV)
        toursRV.isNestedScrollingEnabled = false


        //add items to array list

        val places =ArrayList<Places>()

        places.add(
            Places(
                "Infill Branch",
                "infillb",
                4.5f,
                "https://images.unsplash.com/photo-1519817914152-22d216bb9170?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=401&q=80"


        )
        )

        places.add(
            Places(
                "Site branch",
                "sector 1",
                4.5f,
                "https://images.unsplash.com/photo-1575239005176-a1e644188f51?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"


            )
        )
        places.add(
            Places(
                "Central branch",
                "sector 1",
                4.5f,
                "https://images.unsplash.com/photo-1575540325855-4b5d285a3845?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80"

            )
        )

        //add array list to recyclerview

        toursRV.adapter = TourAdapter( this,places)
    }
}

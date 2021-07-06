package com.example.confPlatziTest.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.confPlatziTest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.toolbarMain))

        configNav()
        /* up data to firebase
        val firebaseFirestore = FirebaseFirestore.getInstance()
        for(i in 0 until jsonArr.length()){
            val aux = jsonArr.get(i) as JSONObject
            var speaker = Speaker()
            speaker.name = aux.getString("name")
            speaker.jobtitle = aux.getString("jobtitle")
            speaker.workplace = aux.getString("workplace")
            speaker.biography = aux.getString("biography")
            speaker.twitter = aux.getString("twitter")
            speaker.image = aux.getString("image")
            speaker.category = aux.getInt("category")

            firebaseFirestore.collection("speakers").document().set(speaker)
        }

        for(i in 0 until jsonArr2.length()){
            val aux = jsonArr2.get(i) as JSONObject
            var conference = Conference()
            conference.title = aux.getString("title")
            conference.description = aux.getString("description")
            conference.tag = aux.getString("tag")
            val cal = Calendar.getInstance()
            cal.timeInMillis = aux.getLong("datetime") * 1000
            conference.datetime = cal.time
            conference.speaker = aux.getString("speaker")

            firebaseFirestore.collection("conferences").document().set(conference)
        }

         */

    }

    fun configNav(){
        NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }
}
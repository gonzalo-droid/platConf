package com.example.confPlatziTest.view.adapter

import com.example.confPlatziTest.model.Conference


interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}
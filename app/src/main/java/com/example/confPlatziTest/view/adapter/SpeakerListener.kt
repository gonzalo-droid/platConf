package com.example.confPlatziTest.view.adapter

import android.telecom.Conference
import com.example.confPlatziTest.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker:Speaker, position: Int)
}
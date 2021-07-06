package com.example.confPlatziTest.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.confPlatziTest.R
import com.example.confPlatziTest.model.Conference
import com.example.confPlatziTest.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*
import java.text.SimpleDateFormat

class SpeakersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close,)
        toolbarSpeaker.setTitleTextColor(Color.WHITE)
        toolbarSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker

        toolbarSpeaker.title = speaker.name


        itemDetailSpeakerTitle.text = speaker.name
        itemDetailSpeakerJobTitle.text = speaker.jobtitle
        itemDetailSpeakerWorkPlace.text = speaker.workplace
        itemDetailSpeakerDescription.text = speaker.biography

        Glide.with(itemDetailSpeakerImage.context)
            .load(speaker.image)
//            .apply(RequestOptions.circleCropTransform())
            .into(itemDetailSpeakerImage)


        icTwitter.setOnClickListener {
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/"+url)
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }

//        itemDetailSpeakerImage = speaker.name

    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
    }
}
package com.example.confPlatziTest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.confPlatziTest.R
import com.example.confPlatziTest.model.Conference
import com.example.confPlatziTest.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    var listSpeaker = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpeakerAdapter.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_speakers, parent, false)
    )

    override fun getItemCount() = listSpeaker.size


    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {
        var speaker = listSpeaker[position] as Speaker

        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerDescription.text = speaker.workplace

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivSpeakerImage)

        holder.itemView.setOnClickListener{
            speakerListener.onSpeakerClicked(speaker,position)
        }

    }


    fun updateData(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerDescription = itemView.findViewById<TextView>(R.id.tvItemSpeakerDescription)

        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
    }



}
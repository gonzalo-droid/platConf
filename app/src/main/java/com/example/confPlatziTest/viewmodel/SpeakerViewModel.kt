package com.example.confPlatziTest.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.confPlatziTest.firebase.Callback
import com.example.confPlatziTest.firebase.FirestoreService
import com.example.confPlatziTest.model.Conference
import com.example.confPlatziTest.model.Speaker
import java.lang.Exception

class SpeakerViewModel {
    val firestoreService = FirestoreService()

    var listSpeakerViewModel: MutableLiveData<List<Speaker>> = MutableLiveData()

    //update UI
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakerFromFirebase()
    }
    fun getSpeakerFromFirebase(){
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(resul: List<Speaker>?) {
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}
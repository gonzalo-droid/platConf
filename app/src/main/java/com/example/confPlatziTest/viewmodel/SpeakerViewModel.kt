package com.example.confPlatziTest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.confPlatziTest.firebase.Callback
import com.example.confPlatziTest.firebase.FirestoreService
import com.example.confPlatziTest.model.Conference
import com.example.confPlatziTest.model.Speaker
import java.lang.Exception

class SpeakerViewModel: ViewModel() {
    val firestoreService = FirestoreService()

    var listSpeakerViewModel: MutableLiveData<List<Speaker>> = MutableLiveData()

    //update UI
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakerFromFirebase()
    }
    fun getSpeakerFromFirebase(){
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakerViewModel.postValue(result)
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
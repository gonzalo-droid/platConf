package com.example.confPlatziTest.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.confPlatziTest.firebase.Callback
import com.example.confPlatziTest.firebase.FirestoreService
import com.example.confPlatziTest.model.Conference
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class ScheduleViewModel: ViewModel() {
    val firestoreService= FirestoreService()

    var listScheduleViewModel: MutableLiveData<List<Conference>> = MutableLiveData()

    //update UI
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }
    fun getScheduleFromFirebase(){
        firestoreService.getSchedule(object : Callback<List<Conference>> {
            override fun onSuccess(resul: List<Conference>?) {
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
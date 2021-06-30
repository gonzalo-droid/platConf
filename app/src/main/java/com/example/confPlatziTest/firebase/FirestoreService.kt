package com.example.confPlatziTest.firebase

import com.example.confPlatziTest.model.Conference
import com.example.confPlatziTest.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val SPEAKERS_COLLECTION_NAME = "speakers"
class FirestoreService {

    val firebaseFirestore= FirebaseFirestore.getInstance()

    //setting offline
    val setting = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
    init { //constructor
        firebaseFirestore.firestoreSettings = setting
    }

    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener {result ->
                for (
                    doc in result
                )    {
                    var list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFirestore.collection("conferences")
            .get()
            .addOnSuccessListener {result ->
                for (
                doc in result
                )    {
                    var list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}
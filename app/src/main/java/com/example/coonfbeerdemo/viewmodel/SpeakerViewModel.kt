package com.example.coonfbeerdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coonfbeerdemo.model.Speaker
import com.example.coonfbeerdemo.network.Callback
import com.example.coonfbeerdemo.network.FirestoreService

class SpeakerViewModel: ViewModel() {
    // Esto se va a encargar de comunicar lo que hicimos con la UI de Firestore

    // Creamos una instancia de Firebase que ya la tenemos creada
    val firestoreService = FirestoreService()
    val listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakerFromFirebase()
    }



    fun getSpeakerFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSucces(result: List<Speaker>?) {
                listSpeaker.postValue(result)
                proccessFinish()
            }

            override fun onFail(exception: Exception) {
                proccessFinish()
            }
        })

    }

    fun proccessFinish(){
        isLoading.value = true
    }

}
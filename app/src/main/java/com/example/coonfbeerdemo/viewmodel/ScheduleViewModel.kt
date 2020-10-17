package com.example.coonfbeerdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coonfbeerdemo.network.FirestoreService
import com.example.coonfbeerdemo.model.Conference
import com.example.coonfbeerdemo.network.Callback

class ScheduleViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object: Callback<List <Conference>>{
            override fun onSucces(result: List<Conference>?) {
                listSchedule.postValue(result)
                processFinished()
            }

            override fun onFail(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}
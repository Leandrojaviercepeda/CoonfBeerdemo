package com.example.coonfbeerdemo.view.adapter

import com.example.coonfbeerdemo.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}
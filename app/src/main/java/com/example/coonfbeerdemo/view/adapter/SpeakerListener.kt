package com.example.coonfbeerdemo.view.adapter

import com.example.coonfbeerdemo.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked (speaker: Speaker, position: Int)
}
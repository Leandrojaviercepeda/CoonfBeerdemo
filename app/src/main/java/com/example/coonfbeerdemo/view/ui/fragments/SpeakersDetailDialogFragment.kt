package com.example.coonfbeerdemo.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.coonfbeerdemo.R
import com.example.coonfbeerdemo.model.Speaker
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*

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
        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close_white)
        toolbarSpeaker.setTitleTextColor((Color.WHITE))
        toolbarSpeaker.setNavigationOnClickListener{
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeaker.title = speaker.name
        toolbarSpeaker.setTitleTextColor(Color.WHITE)

        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerWorkplace.text = speaker.workplace
        tvDetailSpeakerJobtitle.text = speaker.jobtitle
        tvDetailSpeakerBiography.text = speaker.biography

        Glide.with(this)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailSpeakerImage)

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }


}
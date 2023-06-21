package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.mvp.databinding.ActivityContainerBinding

class ContainerActivity : AppCompatActivity() {

    private var binding: ActivityContainerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}

package com.bignerdranch.android.mvp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.mvp.COUNTER_ONE
import com.bignerdranch.android.mvp.COUNTER_THREE
import com.bignerdranch.android.mvp.COUNTER_TWO
import com.bignerdranch.android.mvp.databinding.ActivityMainBinding
import com.bignerdranch.android.mvp.presenter.CountersPresenter

class MainActivity : AppCompatActivity(), MainView {

    lateinit var binding: ActivityMainBinding
    private val presenter = CountersPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }
        onClick(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            COUNTER_ONE -> binding.btnCounter1.text = text
            COUNTER_TWO -> binding.btnCounter2.text = text
            COUNTER_THREE -> binding.btnCounter3.text = text
        }
    }

    private fun onClick(listener: View.OnClickListener) {
        with(binding) {
            btnCounter1.setOnClickListener(listener)
            btnCounter2.setOnClickListener(listener)
            btnCounter3.setOnClickListener(listener)
        }
    }

    override fun getButtonText(selectBtn: Int): Int { return selectBtn }
}
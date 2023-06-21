package com.bignerdranch.android.mvp.lesson2_moxy_cicerone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.mvp.databinding.FragmentUsersBinding
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.adapter.UsersRVAdapter
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.presenter.MainPresenter
import com.bignerdranch.android.mvp.lesson2_moxy_cicerone.view.MainView
import moxy.MvpAppCompatFragment

class FragmentUsers : MvpAppCompatFragment(),MainView {

    private var _binding : FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private var adapter: UsersRVAdapter? = null
    lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.rvUsers.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
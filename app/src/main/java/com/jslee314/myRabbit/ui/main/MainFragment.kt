package com.jslee314.myRabbit.ui.main

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.jslee314.myRabbit.AppApplication
import com.jslee314.myRabbit.MainActivity
import com.jslee314.myRabbit.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((activity?.application as AppApplication))
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        mainViewModel.progressBarHP.observe(viewLifecycleOwner){
            it?.let {
                binding.progressBarHP.progress = it
            }
        }

        mainViewModel.progressBarMP.observe(viewLifecycleOwner){
            it?.let {
                binding.progressBarMP.progress = it
            }
        }

        mainViewModel.progressBarSP.observe(viewLifecycleOwner){
            it?.let {
                binding.progressBarSP.progress = it
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
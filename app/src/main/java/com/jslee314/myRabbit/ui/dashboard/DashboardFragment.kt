package com.jslee314.myRabbit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.jslee314.myRabbit.AppApplication
import com.jslee314.myRabbit.databinding.FragmentDashboardBinding
import com.jslee314.myRabbit.ui.main.MainViewModel
import com.jslee314.myRabbit.ui.main.MainViewModelFactory

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val dashboardViewModel : DashboardViewModel by viewModels {
        DashboardViewModelFactory((activity?.application as AppApplication))
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        dashboardViewModel.title.observe(viewLifecycleOwner) {
            binding.textDashboard.text = it
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
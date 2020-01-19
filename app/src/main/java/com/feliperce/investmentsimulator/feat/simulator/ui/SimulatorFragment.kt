package com.feliperce.investmentsimulator.feat.simulator.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.feliperce.investmentsimulator.R
import com.feliperce.investmentsimulator.databinding.FragmentSimulatorBinding
import com.feliperce.investmentsimulator.feat.simulator.viewmodel.SimulatorViewModel
import org.koin.android.ext.android.inject

class SimulatorFragment : Fragment() {

    private val viewModel: SimulatorViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSimulatorBinding>(
            inflater, R.layout.fragment_simulator, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}

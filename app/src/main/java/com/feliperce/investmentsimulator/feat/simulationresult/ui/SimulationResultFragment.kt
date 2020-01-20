package com.feliperce.investmentsimulator.feat.simulationresult.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.feliperce.investmentsimulator.R
import com.feliperce.investmentsimulator.databinding.FragmentSimulationResultBinding
import com.feliperce.investmentsimulator.feat.simulationresult.viewModel.SimulationResultViewModel
import kotlinx.android.synthetic.main.fragment_simulation_result.*
import org.koin.android.ext.android.inject

class SimulationResultFragment : Fragment() {

    private val args: SimulationResultFragmentArgs by navArgs()
    private val viewModel: SimulationResultViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSimulationResultBinding>(
            inflater, R.layout.fragment_simulation_result, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.formatData(args.InvestmentArg)

        simulateButton.setOnClickListener {
            val action = SimulationResultFragmentDirections
                .actionSimulationResultFragmentToSimulatorFragment()
            findNavController().navigate(action)
        }
    }
}

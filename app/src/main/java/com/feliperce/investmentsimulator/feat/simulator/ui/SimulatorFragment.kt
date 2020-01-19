package com.feliperce.investmentsimulator.feat.simulator.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.feliperce.investmentsimulator.R
import com.feliperce.investmentsimulator.databinding.FragmentSimulatorBinding
import com.feliperce.investmentsimulator.feat.simulator.viewmodel.SimulatorViewModel
import com.feliperce.investmentsimulator.utils.extension.addTextChangeWithCurrencyFormatListener
import com.feliperce.investmentsimulator.utils.extension.onDateSelectListener
import kotlinx.android.synthetic.main.fragment_simulator.*
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toApplyEditText.addTextChangeWithCurrencyFormatListener()

        applyMonthEditText.onDateSelectListener(requireContext()) {
            applyMonthEditText.setText(this)
        }
    }


}

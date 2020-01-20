package com.feliperce.investmentsimulator.feat.simulator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import com.feliperce.investmentsimulator.data.repository.SimulatorRepository
import com.feliperce.investmentsimulator.data.statushandler.Status
import com.feliperce.investmentsimulator.exception.ErrorException
import com.feliperce.investmentsimulator.utils.extension.stringCurrencyToBigDecimal
import com.feliperce.investmentsimulator.utils.extension.toFormattedDate
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SimulatorViewModel(private val simulatorRepository: SimulatorRepository) : ViewModel() {

    private val dataLoading = MutableLiveData<Boolean>()
    val dataLoadingLiveData: LiveData<Boolean> = dataLoading

    private val formValidation = MutableLiveData<Boolean>()
    val formValidationLiveData: LiveData<Boolean> = formValidation

    private val simulator = MutableLiveData<InvestmentSimulationResponse>()
    var simulatorLiveData: LiveData<InvestmentSimulationResponse> = simulator

    private val errorHandler = MutableLiveData<ErrorException>()
    val errorHandlerLiveData: LiveData<ErrorException> = errorHandler

    fun formValidate(toApply: String,
                 applyMonth: String,
                 percent: String) {
        if (toApply.isNotBlank() &&
                applyMonth.isNotBlank() &&
                percent.isNotBlank()) {
            formValidation.postValue(true)
        } else {
            formValidation.postValue(false)
        }
    }

    fun simulate(investedAmount: String,
                 index: String,
                 rate: String,
                 isTaxFree: Boolean,
                 maturityDate: String) {

        val amount = investedAmount.stringCurrencyToBigDecimal()

        viewModelScope.launch {
            simulatorRepository.getSimulation(
                amount,
                index,
                rate.toInt(),
                isTaxFree,
                maturityDate.toFormattedDate()
            ).collect { res ->
                when (res.status) {
                    is Status.Success -> {
                        simulator.postValue(res.data)
                    }
                    is Status.Loading -> {
                        dataLoading.postValue(res.status.isLoading)
                    }
                    is Status.Error -> {
                        errorHandler.postValue(res.status.exception)
                    }
                }
            }
        }

    }
}
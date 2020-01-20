package com.feliperce.investmentsimulator.feat.simulator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import com.feliperce.investmentsimulator.data.repository.SimulatorRepository
import com.feliperce.investmentsimulator.exception.ErrorException

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

    fun simulate(investmentAmount: Long,
                 index: String,
                 rate: Int,
                 isTaxFree: Boolean,
                 maturityDate: String) {

    }
}
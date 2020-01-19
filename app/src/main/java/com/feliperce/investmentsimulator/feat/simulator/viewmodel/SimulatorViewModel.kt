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

    private val simulator = MutableLiveData<InvestmentSimulationResponse>()
    var simulatorLiveData: LiveData<InvestmentSimulationResponse> = simulator

    private val errorHandler = MutableLiveData<ErrorException>()
    val errorHandlerLiveData: LiveData<ErrorException> = errorHandler

    fun validate(investmentAmount: Long,
                 index: String,
                 rate: Int,
                 isTaxFree: Boolean,
                 maturityDate: String) {

    }

    fun simulate(investmentAmount: Long,
                 index: String,
                 rate: Int,
                 isTaxFree: Boolean,
                 maturityDate: String) {

    }
}
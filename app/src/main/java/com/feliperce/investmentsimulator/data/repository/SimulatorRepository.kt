package com.feliperce.investmentsimulator.data.repository

import androidx.annotation.WorkerThread
import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import com.feliperce.investmentsimulator.data.remote.service.InvestmentService
import com.feliperce.investmentsimulator.data.statushandler.Resource
import com.feliperce.investmentsimulator.utils.extension.networkCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import retrofit2.Retrofit
import java.math.BigDecimal

class SimulatorRepository(private val retrofit: Retrofit,
                          private val investmentService: InvestmentService) {

    @WorkerThread
    suspend fun getSimulation(
        investedAmount: BigDecimal,
        index: String,
        rate: Int,
        isTaxFree: Boolean,
        maturityDate: String
    ): Flow<Resource<InvestmentSimulationResponse>> = flow {
        emit(retrofit.networkCall {
            investmentService.getInvestmentSimulation(
                investedAmount,
                index,
                rate,
                isTaxFree,
                maturityDate
            ).await()
        })
    }.onStart {
        emit(Resource.loading(true))
    }.onCompletion {
        emit(Resource.loading(false))
    }
}

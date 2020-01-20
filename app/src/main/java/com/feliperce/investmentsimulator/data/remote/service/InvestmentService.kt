package com.feliperce.investmentsimulator.data.remote.service

import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigDecimal

interface InvestmentService {

    companion object {
        const val INVESTMENT_SIMULATE_PATH = "calculator/simulate"
    }

    @GET(INVESTMENT_SIMULATE_PATH)
    fun getInvestmentSimulation(
        @Query("investedAmount") investedAmount: BigDecimal,
        @Query("index") index: String,
        @Query("rate") rate: Int,
        @Query("isTaxFree") isTaxFree: Boolean,
        @Query("maturityDate") maturityDate: String
    ): Deferred<Response<InvestmentSimulationResponse>>

}
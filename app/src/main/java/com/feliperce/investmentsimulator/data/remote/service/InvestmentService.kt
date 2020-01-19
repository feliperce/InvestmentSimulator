package com.feliperce.investmentsimulator.data.remote.service

import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InvestmentService {

    companion object {
        const val INVESTMENT_SIMULATE_PATH = "calculator/simulate"
    }

    @GET(INVESTMENT_SIMULATE_PATH)
    fun getInvestmentSimulation(
        @Path("investmentAmount") investmentAmount: Long,
        @Path("index") index: String,
        @Path("rate") rate: Int,
        @Path("isTaxFree") isTaxFree: Boolean,
        @Path("maturityDate") maturityDate: String
    ): Deferred<Response<InvestmentSimulationResponse>>

}
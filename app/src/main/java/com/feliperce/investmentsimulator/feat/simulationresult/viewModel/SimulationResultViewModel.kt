package com.feliperce.investmentsimulator.feat.simulationresult.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feliperce.investmentsimulator.data.remote.response.InvestmentSimulationResponse
import com.feliperce.investmentsimulator.utils.extension.iso9801ToDateFormattedString
import com.feliperce.investmentsimulator.utils.extension.toCurrencyString

class SimulationResultViewModel : ViewModel() {

    private val investedAmount = MutableLiveData<String>()
    val investedAmountLiveData: LiveData<String> = investedAmount

    private val grossValueAmount = MutableLiveData<String>()
    val grossValueAmountLiveData: LiveData<String> = grossValueAmount

    private val profitTotal = MutableLiveData<String>()
    val profitTotalLiveData: LiveData<String> = profitTotal

    private val initialAmount = MutableLiveData<String>()
    val initialAmountLiveData: LiveData<String> = initialAmount

    private val profitAmount = MutableLiveData<String>()
    val profitAmountLiveData: LiveData<String> = profitAmount

    private val irAmount = MutableLiveData<String>()
    val irAmountLiveData: LiveData<String> = irAmount
    private val taxRate = MutableLiveData<String>()
    val taxRateLiveData: LiveData<String> = taxRate

    private val netValueAmount = MutableLiveData<String>()
    val netAmountLiveData: LiveData<String> = netValueAmount

    private val maturityDate = MutableLiveData<String>()
    val maturityDateLiveData: LiveData<String> = maturityDate

    private val maturityDays = MutableLiveData<String>()
    val maturityDaysLiveData: LiveData<String> = maturityDays

    private val monthProfit = MutableLiveData<String>()
    val monthProfitLiveData: LiveData<String> = monthProfit

    private val investmentPercent = MutableLiveData<String>()
    val investmentPercentLiveData: LiveData<String> = investmentPercent

    private val yearProfit = MutableLiveData<String>()
    val yearProfitLiveData: LiveData<String> = yearProfit

    private val rateValueProfit = MutableLiveData<String>()
    val rateProfitLiveData: LiveData<String> = rateValueProfit

    fun formatData(response: InvestmentSimulationResponse) {
        with(response) {
            investedAmount.postValue(grossAmount?.toCurrencyString())
            grossValueAmount.postValue(grossAmount?.toCurrencyString())
            profitTotal.postValue(grossAmountProfit?.toCurrencyString())
            initialAmount.postValue(investmentParameter?.investedAmount?.toCurrencyString())
            profitAmount.postValue(grossAmountProfit?.toCurrencyString())
            irAmount.postValue(taxesAmount?.toCurrencyString())
            taxRate.postValue(taxesRate?.toPlainString())
            netValueAmount.postValue(netAmount?.toCurrencyString())
            maturityDate.postValue(investmentParameter?.maturityDate?.iso9801ToDateFormattedString())
            maturityDays.postValue(investmentParameter?.maturityTotalDays.toString())
            monthProfit.postValue(monthlyGrossRateProfit?.toPlainString())
            investmentPercent.postValue(investmentParameter?.rate?.toPlainString())
            yearProfit.postValue(annualGrossRateProfit?.toPlainString())
            rateValueProfit.postValue(rateProfit?.toPlainString())
        }
    }
}
package com.feliperce.investmentsimulator.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class InvestmentSimulationResponse(
	val dailyGrossRateProfit: Double? = null,
	val investmentParameter: @RawValue InvestmentParameter? = null,
	val monthlyGrossRateProfit: Double? = null,
	val netAmount: Double? = null,
	val grossAmountProfit: Double? = null,
	val annualGrossRateProfit: Double? = null,
	val taxesAmount: Double? = null,
	val netAmountProfit: Double? = null,
	val rateProfit: Double? = null,
	val grossAmount: Double? = null,
	val taxesRate: Double? = null,
	val annualNetRateProfit: Double? = null
) : Parcelable

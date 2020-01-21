package com.feliperce.investmentsimulator.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.math.BigDecimal

@Parcelize
data class InvestmentSimulationResponse(
    val dailyGrossRateProfit: BigDecimal? = null,
    val investmentParameter: @RawValue InvestmentParameter? = null,
    val monthlyGrossRateProfit: BigDecimal? = null,
    val netAmount: BigDecimal? = null,
    val grossAmountProfit: BigDecimal? = null,
    val annualGrossRateProfit: BigDecimal? = null,
    val taxesAmount: BigDecimal? = null,
    val netAmountProfit: BigDecimal? = null,
    val rateProfit: BigDecimal? = null,
    val grossAmount: BigDecimal? = null,
    val taxesRate: BigDecimal? = null,
    val annualNetRateProfit: BigDecimal? = null
) : Parcelable

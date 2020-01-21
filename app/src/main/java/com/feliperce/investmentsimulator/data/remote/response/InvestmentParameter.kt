package com.feliperce.investmentsimulator.data.remote.response

import java.math.BigDecimal

data class InvestmentParameter(
    val rate: BigDecimal? = null,
    val maturityDate: String? = null,
    val maturityBusinessDays: Int? = null,
    val investedAmount: BigDecimal? = null,
    val maturityTotalDays: Int? = null,
    val isTaxFree: Boolean? = null,
    val yearlyInterestRate: BigDecimal? = null
)

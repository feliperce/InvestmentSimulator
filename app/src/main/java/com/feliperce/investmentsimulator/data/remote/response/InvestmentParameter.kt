package com.feliperce.investmentsimulator.data.remote.response

data class InvestmentParameter(
	val rate: Double? = null,
	val maturityDate: String? = null,
	val maturityBusinessDays: Int? = null,
	val investedAmount: Double? = null,
	val maturityTotalDays: Int? = null,
	val isTaxFree: Boolean? = null,
	val yearlyInterestRate: Double? = null
)

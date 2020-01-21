package com.feliperce.investmentsimulator.utils.extension

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal
import java.text.ParseException
import org.hamcrest.CoreMatchers.`is` as Is

class FormatExtensionTest {

    @Test
    fun `iso9801ToDateFormattedString default pattern return br date`() {
        assertThat("2020-03-27T00:00:00".iso9801ToDateFormattedString(), Is("27/03/2020"))
        assertThat("3000-01-01T12:10:05".iso9801ToDateFormattedString(), Is("01/01/3000"))
        assertThat("2000-03-27T01:10:05".iso9801ToDateFormattedString(), Is("27/03/2000"))
        assertThat("1900-05-22T11:11:11".iso9801ToDateFormattedString(), Is("22/05/1900"))
    }

    @Test(expected= ParseException::class)
    fun `iso9801ToDateFormattedString default pattern invalid format throw ParseException`() {
        "jghjghjgj".iso9801ToDateFormattedString()
    }

    @Test(expected= ParseException::class)
    fun `iso9801ToDateFormattedString custom pattern invalid format throw ParseException`() {
        "jghjghjgj".iso9801ToDateFormattedString("yyyy-MM-dd")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `iso9801ToDateFormattedString invalid pattern return IllegalArgumentException`() {
        "1900-05-22T11:11:11".iso9801ToDateFormattedString("gjgjgjgj")
    }

    @Test
    fun `toFormattedDate default pattern return us pattern`() {
        assertThat("21/05/1991".toFormattedDate(), Is("1991-05-21"))
        assertThat("01/01/1991".toFormattedDate(), Is("1991-01-01"))
        assertThat("3/2/1991".toFormattedDate(), Is("1991-02-03"))
    }

    @Test
    fun `stringCurrencyToBigDecimal default locale return formatted BigDecimal`() {
        assertThat("1.255,50".stringCurrencyToBigDecimal(), Is(BigDecimal("1255.50")))
        assertThat("9.999,99".stringCurrencyToBigDecimal(), Is(BigDecimal("9999.99")))
        assertThat("0,10".stringCurrencyToBigDecimal(), Is(BigDecimal("0.10")))
        assertThat("1.255,50".stringCurrencyToBigDecimal(), Is(BigDecimal("1255.50")))
        assertThat("1.255.999.555,00".stringCurrencyToBigDecimal(), Is(BigDecimal("1255999555.00")))
    }

    @Test
    fun `toCurrencyString default locale return formatted String`() {
        assertThat(BigDecimal("1255.50").toCurrencyString(), Is("1.255,50"))
        assertThat(BigDecimal("9999.99").toCurrencyString(), Is("9.999,99"))
        assertThat(BigDecimal("0.10").toCurrencyString(), Is("0,10"))
        assertThat(BigDecimal("1255.50").toCurrencyString(), Is("1.255,50"))
        assertThat(BigDecimal("1255999555.00").toCurrencyString(), Is("1.255.999.555,00"))
    }


}
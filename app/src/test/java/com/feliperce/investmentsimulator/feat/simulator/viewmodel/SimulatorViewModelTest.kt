package com.feliperce.investmentsimulator.feat.simulator.viewmodel

import com.feliperce.investmentsimulator.data.repository.SimulatorRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.notNullValue
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.robolectric.RobolectricTestRunner
import org.hamcrest.CoreMatchers.`is` as Is

@RunWith(RobolectricTestRunner::class)
class SimulatorViewModelTest : AutoCloseKoinTest() {

    private lateinit var viewModel: SimulatorViewModel

    private val simulatorRepository: SimulatorRepository by inject()

    @Before
    fun setUp() {
        this.viewModel = SimulatorViewModel(simulatorRepository)
    }


    @Test
    fun `validate form return true`() = runBlocking {
        with(viewModel) {
            formValidate("1.000,52", "20/3/2021", "100")
            formValidationLiveData.observeForever {
                assertThat(it, Is(notNullValue()))
                assertThat(it, Is(true))
            }
            simulatorLiveData.observeForever {
                assertThat(it, Is(notNullValue()))
            }
        }

    }

    @Test
    fun `validate empty form return false`() = runBlocking {
        with(viewModel) {
            formValidate("1.000,52", "20/3/2021", "")
            formValidate("1.000,52", "", "100")
            formValidate("", "20/3/2021", "100")
            formValidate("1.000,52", "", "")
            formValidate("", "20/3/2021", "")
            formValidate("", "", "")
            formValidationLiveData.observeForever {
                assertThat(it, Is(notNullValue()))
                assertThat(it, Is(false))
            }
        }
    }

    @Test
    fun `simulate is loading return true`() = runBlocking {
        with(viewModel) {
            simulate("1.000,52", "CDI", "100", false, "20/3/2021")
            simulatorLiveData.observeForever {
                assertThat(dataLoadingLiveData.value, Is(notNullValue()))
                assertThat(dataLoadingLiveData.value, Is(true))
            }
        }

    }

    @Test
    fun `simulate simulator success`() = runBlocking {
        with(viewModel) {
            simulate("1.000,52", "CDI", "100", false, "20/3/2021")
            simulatorLiveData.observeForever {
                assertThat(it, Is(notNullValue()))
            }
        }

    }

    @Test
    fun `simulate simulator error`() = runBlocking {
        with(viewModel) {
            simulate("1.000,52", "", "100", false, "20/3/2021")
            simulatorLiveData.observeForever {
                assertThat(it, Is(nullValue()))
            }
        }

    }

    @Test(expected = NumberFormatException::class)
    fun `simulate error return numberformat exception`() = runBlocking {
        viewModel.simulate("", "CDI", "100", false, "20/3/2021")
    }
}
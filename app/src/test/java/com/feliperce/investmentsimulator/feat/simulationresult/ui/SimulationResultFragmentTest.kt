package com.feliperce.investmentsimulator.feat.simulationresult.ui


import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.feliperce.investmentsimulator.R
import com.feliperce.investmentsimulator.feat.simulator.ui.SimulatorFragment
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SimulationResultFragmentTest : AutoCloseKoinTest() {


    @Test
    fun `form start empty values`() {
        val scenario = launchFragmentInContainer<SimulatorFragment>()
        onView(withId(R.id.toApplyEditText)).check(matches(withText("")))
        onView(withId(R.id.applyMonthEditText)).check(matches(withText("")))
        onView(withId(R.id.percentEditText)).check(matches(withText("")))
    }

    @Test
    fun `simulate button start disabled`() {
        val scenario = launchFragmentInContainer<SimulatorFragment>()
        onView(withId(R.id.simulateButton)).check(matches(not(isEnabled())))
    }

    @Test
    fun `form recreate start empty values`() {
        val scenario = launchFragmentInContainer<SimulatorFragment>()

        onView(withId(R.id.toApplyEditText)).perform(typeText("100"))
        onView(withId(R.id.applyMonthEditText)).perform(typeText("10/10/2020"))
        onView(withId(R.id.percentEditText)).perform(typeText("100"))

        scenario.recreate()

        onView(withId(R.id.toApplyEditText)).check(matches(withText("")))
        onView(withId(R.id.applyMonthEditText)).check(matches(withText("")))
        onView(withId(R.id.percentEditText)).check(matches(withText("")))
    }

    @Test
    fun `month edittext prevent typing`() {
        val scenario = launchFragmentInContainer<SimulatorFragment>()

        onView(withId(R.id.applyMonthEditText)).perform(typeText("10/10/2020"))
        onView(withId(R.id.applyMonthEditText)).check(matches(withText("")))
    }

    @Test
    fun `simulate button enabled when form complete`() {
        val scenario = launchFragmentInContainer<SimulatorFragment>()

        onView(withId(R.id.toApplyEditText)).perform(replaceText("1000"))
        onView(withId(R.id.applyMonthEditText)).perform(replaceText("10/10/2020"))
        onView(withId(R.id.percentEditText)).perform(replaceText("100"))

        onView(withId(R.id.simulateButton)).check(matches(isEnabled()))
    }

}
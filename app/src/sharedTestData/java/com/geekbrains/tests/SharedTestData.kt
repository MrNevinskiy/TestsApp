package com.geekbrains.tests

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

internal const val TEST_NUMBER = 42
internal const val TEST_SEARCH_STRING = "algol"
internal const val TEST_TIMEOUT = 5000L
internal const val TEST_NUMBER_OF_RESULTS_ZERO = "Number of results: 0"
internal const val TEST_NUMBER_OF_RESULTS_PLUS_1 = "Number of results: 1"
internal const val TEST_NUMBER_OF_RESULTS_PLUS_5 = "Number of results: 5"
internal const val TEST_NUMBER_OF_RESULTS_MINUS_1 = "Number of results: -1"
internal const val TEST_NUMBER_OF_RESULTS_MINUS_5 = "Number of results: -5"

fun view_isDisplayed(resId: Int){
    Espresso.onView(ViewMatchers.withId(resId))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}


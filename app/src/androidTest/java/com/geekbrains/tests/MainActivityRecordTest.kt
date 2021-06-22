package com.geekbrains.tests


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityRecordTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val editText = onView(
allOf(withId(R.id.searchEditText), withText("Enter keyword e.g. android"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText.check(matches(withText("Enter keyword e.g. android")))
        
        val button = onView(
allOf(withId(R.id.button_search), withText("Search"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button.check(matches(isDisplayed()))
        
        val editText2 = onView(
allOf(withId(R.id.searchEditText), withText("Enter keyword e.g. android"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        editText2.check(matches(withText("arg")))
        
        val button2 = onView(
allOf(withId(R.id.toDetailsActivityButton), withText("to details"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button2.check(doesNotExist())
        
        val viewGroup = onView(
allOf(withParent(allOf(withId(android.R.id.content),
withParent(withId(R.id.decor_content_parent)))),
isDisplayed()))
        viewGroup.check(matches(isDisplayed()))
        
        val viewGroup2 = onView(
allOf(withParent(allOf(withId(android.R.id.content),
withParent(withId(R.id.decor_content_parent)))),
isDisplayed()))
        viewGroup2.check(matches(isDisplayed()))
        }
    }

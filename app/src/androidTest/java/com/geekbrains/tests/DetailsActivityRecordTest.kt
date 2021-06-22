package com.geekbrains.tests


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailsActivityRecordTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest2() {
        val materialButton = onView(
allOf(withId(R.id.toDetailsActivityButton), withText("to details"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()))
        materialButton.perform(click())
        
        val button = onView(
allOf(withId(R.id.incrementButton), withText("+"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button.check(matches(isDisplayed()))
        
        val button2 = onView(
allOf(withId(R.id.decrementButton), withText("-"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button2.check(matches(isDisplayed()))
        
        val textView = onView(
allOf(withId(R.id.detailsTotalCountTextView), withText("Number of results: 0"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView.check(matches(withText("Number of results: 0")))
        
        val viewGroup = onView(
allOf(withParent(allOf(withId(android.R.id.content),
withParent(withId(R.id.decor_content_parent)))),
isDisplayed()))
        viewGroup.check(matches(isDisplayed()))
        
        val viewGroup2 = onView(
allOf(withParent(allOf(withId(android.R.id.content),
withParent(withId(R.id.decor_content_parent)))),
isDisplayed()))
        viewGroup2.check(doesNotExist())
        
        val button3 = onView(
allOf(withId(R.id.incrementButton), withText("+"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button3.check(doesNotExist())
        
        val button4 = onView(
allOf(withId(R.id.incrementButton), withText("+"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        button4.check(doesNotExist())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }

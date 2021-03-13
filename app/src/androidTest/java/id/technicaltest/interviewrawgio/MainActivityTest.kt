package id.technicaltest.interviewrawgio

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.technicaltest.interviewrawgio.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    //rule test home navbar
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private fun waiter() {
        Thread.sleep(2000L)
    }

    @Test
    fun gamesFragment() {
        onView(withId(R.id.navigation_home)).perform(click())
        waiter()
    }

    @Test
    fun searchFragment(){
        onView(withId(R.id.navigation_search)).perform(click())
        waiter()
    }

    @Test
    fun favoriteFragment() {
        onView(withId(R.id.navigation_favorite)).perform(click())
        waiter()
    }
}
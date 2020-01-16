package com.illicitintelligence.myrealtimeapp

import org.junit.Test
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.illicitintelligence.myrealtimeapp.view.MainActivity
import org.junit.Rule

class InstrumentedTest {


    @Rule
    var testRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

}
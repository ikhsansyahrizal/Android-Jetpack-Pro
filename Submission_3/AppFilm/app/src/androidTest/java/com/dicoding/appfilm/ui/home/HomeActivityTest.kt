package com.dicoding.appfilm.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.appfilm.R
import com.dicoding.appfilm.utils.DataDummy
import com.dicoding.appfilm.utils.DataDummyTesting
import com.dicoding.appfilm.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private val dummyMovie = DataDummyTesting.generateDummyTesting()
    private val dummyTvShow = DataDummyTesting.generateDummyTesting()


    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detailFilm)).check(matches(isDisplayed()))

        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))

        onView(withId(R.id.detailFilm)).perform(ViewActions.swipeUp())
        onView(withId(R.id.floating_btn_share)).perform(click())
    }



    @Test
    fun loadTvShow() {
        onView(withText(R.string.tvShow)).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }


    @Test
    fun loadDetailTvSHow() {
        onView(withText(R.string.tvShow)).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detailFilm)).check(matches(isDisplayed()))

        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[1].title)))

        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[1].overview)))

        onView(withId(R.id.detailFilm)).perform(ViewActions.swipeUp())
        onView(withId(R.id.floating_btn_share)).perform(click())
    }

    @Test
    fun loadFavMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.favorite)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())

    }



    @Test
    fun loadFavTvShow() {
        onView(withText(R.string.tvShow)).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.favorite)).perform(click())
        onView(withText(R.string.tvShow)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())

    }

}
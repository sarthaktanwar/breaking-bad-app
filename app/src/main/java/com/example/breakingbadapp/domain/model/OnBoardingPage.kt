package com.example.breakingbadapp.domain.model

import androidx.annotation.DrawableRes
import com.example.breakingbadapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image:Int,
    val title:String,
    val description:String


){
    object First :OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greeting",
        description = "are you a breaking bad fan ? Because we have a great news for you"
    )
    object Second :OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favourite characters and learn some of the things that you don't know about them "
    )
    object Third :OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your favorite characters power and see how much they are stronger comparing to others  "
    )
}

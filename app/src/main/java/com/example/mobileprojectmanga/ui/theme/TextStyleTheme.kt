package com.example.mobileprojectmanga.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

//val Roboto = FontFamily(
//    Font(R.font.roboto_regular),
//    Font(R.font.roboto_medium, FontWeight.Medium),
//    Font(R.font.roboto_bold, FontWeight.Bold),
//    Font(R.font.roboto_black, FontWeight.Black)
//
//)

object TextStyleTheme {

    val body = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = ColorTheme.textPrimary
    )
}
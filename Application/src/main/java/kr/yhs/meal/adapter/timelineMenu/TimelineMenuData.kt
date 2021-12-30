package kr.yhs.meal.adapter.timelineMenu

data class TimelineMenuData (
    var name: String,
    val leftBar: Boolean? = null,
    val rightBar: Boolean? = null,
    val center: Boolean = false
)
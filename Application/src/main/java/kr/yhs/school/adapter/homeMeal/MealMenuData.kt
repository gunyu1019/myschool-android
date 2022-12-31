package kr.yhs.school.adapter.homeMeal

data class MealMenuData (
    var name: String,
    var allergyWarning: Boolean = false,
    var starFood: Boolean = false,
)
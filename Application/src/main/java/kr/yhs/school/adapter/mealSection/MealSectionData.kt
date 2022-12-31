package kr.yhs.school.adapter.mealSection

import kr.yhs.school.adapter.homeMeal.MealMenuAdapter

data class MealSectionData (
    val mealType: String,
    val calories: Float = 0.0F,
    val adapter: MealMenuAdapter? = null,
)
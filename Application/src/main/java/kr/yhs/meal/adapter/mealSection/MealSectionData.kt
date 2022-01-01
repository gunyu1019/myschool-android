package kr.yhs.meal.adapter.mealSection

import kr.yhs.meal.adapter.homeMeal.MealMenuAdapter

data class MealSectionData (
    val mealType: String,
    val calories: Float = 0.0F,
    val adapter: MealMenuAdapter? = null
)
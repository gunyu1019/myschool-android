package kr.yhs.meal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.yhs.meal.adapter.mealSection.MealSectionAdapter
import kr.yhs.meal.adapter.mealSection.MealSectionData
import kr.yhs.meal.databinding.MealFragmentBinding

class MealFragement : Fragment(R.layout.meal_fragment) {
    private var mBinding: MealFragmentBinding? = null
    private val binding get() = mBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = MealFragmentBinding.bind(view)
        val mealData = arrayListOf(
            MealSectionData(mealType = "아침", calories = 0.0F),
            MealSectionData(mealType = "점심", calories = 0.0F),
            MealSectionData(mealType = "저녁", calories = 0.0F)
        )
        binding.mealRecyclerView.adapter = MealSectionAdapter(view.context, mealData)
    }
}
package kr.yhs.meal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.yhs.meal.adapter.homeMeal.MealMenuAdapter
import kr.yhs.meal.adapter.homeMeal.MealMenuData
import kr.yhs.meal.adapter.mealSection.MealSectionAdapter
import kr.yhs.meal.adapter.mealSection.MealSectionData
import kr.yhs.meal.databinding.MealFragmentBinding

class MealFragement : Fragment(R.layout.meal_fragment) {
    private var mBinding: MealFragmentBinding? = null
    private val binding get() = mBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = MealFragmentBinding.bind(view)

        val mealItem = arrayListOf(
            MealMenuData(name="나시고랭볶음밥", starFood = true),
            MealMenuData(name="가스오부시장국", allergyWarning = true),
            MealMenuData(name="마요순살치킨", starFood = true),
            MealMenuData(name="시카고치즈피자", starFood = true),
            MealMenuData(name="배추김치"),
            MealMenuData(name="치킨무"),
            MealMenuData(name="바이오틱스애플소다", starFood = true),
        )

        val mealData = arrayListOf(
            MealSectionData(mealType = "아침", calories = 0.0F),
            MealSectionData(mealType = "점심", calories = 0.0F, adapter = MealMenuAdapter(view.context, mealItem)),
            MealSectionData(mealType = "저녁", calories = 0.0F)
        )
        val adapter = MealSectionAdapter(mealData)
        adapter.setOnLeftPopupListener { leftPopup(it) }
        adapter.setOnRightPopupListener { rightPopup(it) }
        binding.mealRecyclerView.adapter = adapter
    }

    private fun leftPopup(mealType: String) {
        val intent = Intent(this.context, PopupActivity::class.java)
        startActivity(intent)
    }

    private fun rightPopup(mealType: String) {
        val intent = Intent(this.context, PopupActivity::class.java)
        startActivity(intent)
    }
}
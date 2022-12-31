package kr.yhs.school

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.yhs.school.adapter.homeMeal.MealMenuAdapter
import kr.yhs.school.adapter.homeMeal.MealMenuData
import kr.yhs.school.adapter.starlinkMenu.StarlinkMenuAdapter
import kr.yhs.school.adapter.starlinkMenu.StarlinkMenuData
import kr.yhs.school.adapter.timelineMenu.TimelineMenuAdapter
import kr.yhs.school.adapter.timelineMenu.TimelineMenuData
import kr.yhs.school.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment) {
    private var mBinding: HomeFragmentBinding? = null
    private val binding get() = mBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = HomeFragmentBinding.bind(view)
        // Design Test Code
        val mealItem = arrayListOf(
            MealMenuData(name="나시고랭볶음밥", starFood = true),
            MealMenuData(name="가스오부시장국", allergyWarning = true),
            MealMenuData(name="마요순살치킨", starFood = true),
            MealMenuData(name="시카고치즈피자", starFood = true),
            MealMenuData(name="배추김치"),
            MealMenuData(name="치킨무"),
            MealMenuData(name="바이오틱스애플소다", starFood = true),
        )
        binding.homeMealRecyclerView.adapter = MealMenuAdapter(view.context, mealItem)
        val starItem = arrayListOf(
            StarlinkMenuData(
                icon = R.drawable.starlink_hcs
            ), StarlinkMenuData(
                icon = R.drawable.starlink_classting
            ), StarlinkMenuData(
                icon = R.drawable.starlink_zoom
            ), StarlinkMenuData(
                icon = R.drawable.starlink_teams
            )
        )
        binding.starlinkRecycleView.adapter = StarlinkMenuAdapter(starItem)
        val timetableItem = arrayListOf(
            TimelineMenuData(
                "수학"
            ),
            TimelineMenuData(
                "영어",
                center = true
            ),
            TimelineMenuData(
                "프로그래밍"
            ),
            TimelineMenuData(
                "프로그래밍"
            ),
            TimelineMenuData(
                "프로그래밍"
            ),
            TimelineMenuData(
                "프로그래밍"
            ),
            TimelineMenuData(
                "프로그래밍"
            )
        )
        binding.homeTimetableRecyclerView.adapter = TimelineMenuAdapter(this.requireContext(), timetableItem)
    }
}
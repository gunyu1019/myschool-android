package kr.yhs.meal

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.yhs.meal.adapter.homeMeal.MealMenuAdapter
import kr.yhs.meal.adapter.homeMeal.MealMenuData
import kr.yhs.meal.adapter.starlinkMenu.StarlinkMenuAdapter
import kr.yhs.meal.adapter.starlinkMenu.StarlinkMenuData
import kr.yhs.meal.adapter.timelineMenu.TimelineMenuAdapter
import kr.yhs.meal.adapter.timelineMenu.TimelineMenuData
import kr.yhs.meal.databinding.ActivityMainBinding
import kr.yhs.meal.databinding.TimetableItemBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.homeMealRecyclerView.adapter = MealMenuAdapter(this, mealItem)
        val starItem = arrayListOf(
            StarlinkMenuData(
                icon = R.drawable.starlink_hcs
            ), StarlinkMenuData(
                icon = R.drawable.starlink_classting
            ), StarlinkMenuData(
                icon = R.drawable.starlink_iamschool
            ), StarlinkMenuData(
                icon = R.drawable.starlink_riroschool
            )
        )
        binding.starlinkRecycleView.adapter = StarlinkMenuAdapter(this, starItem)
        val timetableItem = arrayListOf(
            TimelineMenuData(
                "수학",
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
            ),
            TimelineMenuData(
                "프로그래밍"
            )
        )
        binding.homeTimetableRecyclerView.adapter = TimelineMenuAdapter(timetableItem)
    }
}
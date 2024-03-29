package kr.yhs.school

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kr.yhs.school.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

    private fun bottomNavigationActivity(): (MenuItem) -> Boolean {
        return fun(item: MenuItem): Boolean {
            when(item.itemId) {
                R.id.home_menu -> changeFragment(HomeFragment())
                R.id.meal_menu -> changeFragment(MealFragment())
                R.id.timetable_menu -> changeFragment(TimetableFragment())
                R.id.setting_menu -> changeFragment(SettingFragment())
            }
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener(bottomNavigationActivity())
        changeFragment(HomeFragment())
    }
}
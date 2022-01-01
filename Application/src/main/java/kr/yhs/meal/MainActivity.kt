package kr.yhs.meal

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import kr.yhs.meal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

    private fun bottomNavigationActivity(): (MenuItem) -> Boolean {
        return fun(item: MenuItem): Boolean {
            when(item.itemId) {
                R.id.home_menu -> changeFragment(HomeFragement())
                R.id.meal_menu -> changeFragment(MealFragement())
            }
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener(bottomNavigationActivity())
        changeFragment(HomeFragement())
    }
}
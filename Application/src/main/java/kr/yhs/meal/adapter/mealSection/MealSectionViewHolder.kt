package kr.yhs.meal.adapter.mealSection

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.meal.R
import org.w3c.dom.Text

class MealSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mealTypeTextView = itemView.findViewById<TextView>(R.id.mealTypeTextView)
    private val leftButton = itemView.findViewById<ConstraintLayout>(R.id.meal_leftButton)
    private val rightButton = itemView.findViewById<ConstraintLayout>(R.id.meal_rightButton)
    private val caloriesTextView = itemView.findViewById<TextView>(R.id.caloriesTextView)
    private val mealRecyclerView = itemView.findViewById<RecyclerView>(R.id.mealSectionRecyclerView)
    private val noMealLayout = itemView.findViewById<LinearLayout>(R.id.noMealLayout)

    fun onBind(data: MealSectionData) {
        mealTypeTextView.text = data.mealType
        caloriesTextView.text = data.calories.toString()

        if (data.adapter == null) {
            mealRecyclerView.visibility = View.INVISIBLE
            noMealLayout.visibility = View.VISIBLE
        } else {
            mealRecyclerView.visibility = View.VISIBLE
            noMealLayout.visibility = View.GONE

            mealRecyclerView.adapter = data.adapter
        }

        leftButton.setOnClickListener {
            data.leftListener.invoke("caloriesData")
        }
        rightButton.setOnClickListener {
            data.rightListener.invoke("originData")
        }
        bindingAdapter
    }
}
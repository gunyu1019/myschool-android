package kr.yhs.meal.adapter.homeMeal

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.Spannable
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.meal.R

class MealMenuViewHolder(itemView: View, private val setIcon: Boolean) : RecyclerView.ViewHolder(itemView) {
    private var nameTextView = itemView.findViewById<TextView>(R.id.foodTextView)
    private var contentImageView = itemView.findViewById<ImageView>(R.id.mealImageView)

    fun onBind(data: MealMenuData, context: Activity) {
        if (setIcon) {
            nameTextView.text = data.name
            when {
                data.allergyWarning -> {
                    contentImageView.setImageResource(R.drawable.ic_baseline_warning)
                    contentImageView.setColorFilter(context.getColor(R.color.warning_food_icon))
                }
                data.starFood -> {
                    contentImageView.setImageResource(R.drawable.ic_baseline_star)
                    contentImageView.setColorFilter(context.getColor(R.color.star_food_icon))
                }
                else -> contentImageView.visibility = View.INVISIBLE
            }
        } else {
            contentImageView.visibility = View.GONE
            contentImageView.setPadding(10, 0, 10,0)
            nameTextView.setText(data.name, TextView.BufferType.SPANNABLE)
            val span = nameTextView.text as Spannable
            when {
                data.allergyWarning -> {
                    span.setSpan(
                        BackgroundColorSpan(context.getColor(R.color.warning_food)),
                        0, data.name.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    span.setSpan(
                        ForegroundColorSpan(context.getColor(R.color.text_color)),
                        0, data.name.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
                data.starFood -> {
                    span.setSpan(
                        BackgroundColorSpan(context.getColor(R.color.star_food)),
                        0, data.name.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    span.setSpan(
                        ForegroundColorSpan(context.getColor(R.color.text_color)),
                        0, data.name.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
        }
        bindingAdapter
    }
}
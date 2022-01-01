package kr.yhs.meal.adapter.mealSection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.meal.R

class MealSectionAdapter(private var data: ArrayList<MealSectionData>? = null): RecyclerView.Adapter<MealSectionViewHolder>() {
    var leftPopupListener: ((String) -> Unit)? = null
    var rightPopupListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealSectionViewHolder {
        val context: Context = parent.context
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.meal_section_item, parent, false)
        return MealSectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealSectionViewHolder, position: Int) {
        if (this.data == null)
            return
        holder.onBind(this.data!![position], leftPopupListener, rightPopupListener)
    }

    override fun getItemCount(): Int {
        if (this.data == null)
            return 0
        return this.data!!.size
    }

    fun setOnLeftPopupListener(function: ((String) -> Unit)) {
        leftPopupListener = function
    }

    fun setOnRightPopupListener(function: ((String) -> Unit)) {
        rightPopupListener = function
    }
}
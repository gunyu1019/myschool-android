package kr.yhs.school.adapter.homeMeal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.school.R

class MealMenuAdapter(private val context: Context, private var data: ArrayList<MealMenuData>? = null): RecyclerView.Adapter<MealMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealMenuViewHolder {
        val context: Context = parent.context
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.meal_item, parent, false)
        return MealMenuViewHolder(view, true)
    }

    override fun onBindViewHolder(holder: MealMenuViewHolder, position: Int) {
        if (this.data == null)
            return
        holder.onBind(this.data!![position], context)
    }

    override fun getItemCount(): Int {
        if (this.data == null)
            return 0
        return this.data!!.size
    }
}
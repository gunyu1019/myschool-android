package kr.yhs.meal.adapter.timelineMenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.meal.R


class TimelineMenuAdapter(private val context: Context, private var data: ArrayList<TimelineMenuData>? = null): RecyclerView.Adapter<TimelineMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineMenuViewHolder {
        val context: Context = parent.context
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.timetable_item, parent, false)
        return TimelineMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineMenuViewHolder, position: Int) {
        if (this.data == null)
            return
        holder.onBind(this.data!![position], position, context)
    }

    override fun getItemCount(): Int {
        if (this.data == null)
            return 0
        return this.data!!.size
    }
}
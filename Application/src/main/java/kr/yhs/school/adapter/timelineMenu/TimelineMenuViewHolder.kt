package kr.yhs.school.adapter.timelineMenu

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.school.R

class TimelineMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var timeTextView = itemView.findViewById<TextView>(R.id.timeTextView)
    private var subjectTextView = itemView.findViewById<TextView>(R.id.subjectTextView)
    private var itemBox = itemView.findViewById<ConstraintLayout>(R.id.itemBox)

    fun onBind(data: TimelineMenuData, position: Int, context: Context) {
        timeTextView.text = context.getString(R.string.timetable_time, position + 1)
        subjectTextView.text = data.name
        if (data.center) {
            itemBox.background = context.getDrawable(R.drawable.background_box_v3_bold)
        }
    }
}
package kr.yhs.meal.adapter.timelineMenu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.meal.R

class TimelineMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var leftBar = itemView.findViewById<ImageView>(R.id.timelineLeft)
    private var rightBar = itemView.findViewById<ImageView>(R.id.timelineRight)
    private var center = itemView.findViewById<ImageView>(R.id.timelineCenter)
    private var subjectTextView = itemView.findViewById<TextView>(R.id.subjectTextView)

    fun onBind(data: TimelineMenuData, position: Int, adapter: TimelineMenuAdapter) {
        if (data.leftBar?:(position != 0))
            leftBar.visibility = View.VISIBLE
        else
            leftBar.visibility = View.INVISIBLE
        if (data.rightBar?:(position != adapter.itemCount - 1))
            rightBar.visibility = View.VISIBLE
        else
            rightBar.visibility = View.INVISIBLE
        subjectTextView.text = data.name

        if (data.center) {
            center.setImageResource(R.drawable.timetable_current_shape)
        }
    }
}
package kr.yhs.school.adapter.starlinkMenu

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.school.R

class StarlinkMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var boxLayout = itemView.findViewById<ConstraintLayout>(R.id.itemBox)
    private var itemTextView = itemView.findViewById<TextView>(R.id.itemTextView)
    private var itemImageView = itemView.findViewById<ImageView>(R.id.itemImage)

    fun onBind(data: StarlinkMenuData) {
        if (data.icon != null) {
            itemImageView.setImageResource(data.icon!!)
            itemImageView.visibility = View.VISIBLE
            itemTextView.visibility = View.GONE
        } else if (data.name != null) {
            itemTextView.text = data.name
            itemImageView.visibility = View.GONE
            itemTextView.visibility = View.VISIBLE
        }
        if (data.clickListener != null)
            boxLayout.setOnClickListener(data.clickListener)
        bindingAdapter
    }
}
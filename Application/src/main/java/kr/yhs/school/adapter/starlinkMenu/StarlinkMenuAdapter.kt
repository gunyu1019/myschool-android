package kr.yhs.school.adapter.starlinkMenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.yhs.school.R




class StarlinkMenuAdapter(private var data: ArrayList<StarlinkMenuData>? = null): RecyclerView.Adapter<StarlinkMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarlinkMenuViewHolder {
        val context: Context = parent.context
        val view: View = LayoutInflater
            .from(context)
            .inflate(R.layout.starlink_item, parent, false)

        val width: Int = parent.measuredWidth / 4
        val height: Int = parent.measuredWidth / 4
        view.layoutParams = RecyclerView.LayoutParams(width, height)

        // val itemImageView = view.findViewById<ImageView>(R.id.itemImage)
        // itemImageView.layoutParams = RecyclerView.LayoutParams(width / 10 * 5, height / 10 * 5)
        return StarlinkMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarlinkMenuViewHolder, position: Int) {
        if (this.data == null)
            return
        holder.onBind(this.data!![position])
    }

    override fun getItemCount(): Int {
        if (this.data == null)
            return 0
        return this.data!!.size
    }
}
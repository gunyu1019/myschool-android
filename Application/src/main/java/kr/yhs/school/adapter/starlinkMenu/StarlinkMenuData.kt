package kr.yhs.school.adapter.starlinkMenu

import android.view.View

data class StarlinkMenuData (
    var icon: Int? = null,
    var name: String? = null,
    val clickListener: View.OnClickListener? = null
)
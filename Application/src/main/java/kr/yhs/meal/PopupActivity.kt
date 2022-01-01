package kr.yhs.meal

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window

class PopupActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_popup)
    }

    fun popupClose(view: View) {
        finish()
    }

    fun popupClose() {
        finish()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_OUTSIDE) {
            popupClose()
            return true
        }
        return super.onTouchEvent(event)
    }

    override fun onBackPressed() {
        popupClose()
        return
    }
}
package kr.yhs.meal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.yhs.meal.databinding.TimetableFragmentBinding

class TimetableFragment : Fragment(R.layout.timetable_fragment) {
    private var mBinding: TimetableFragmentBinding? = null
    private val binding get() = mBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = TimetableFragmentBinding.bind(view)
    }
}
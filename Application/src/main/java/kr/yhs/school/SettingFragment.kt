package kr.yhs.school

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kr.yhs.school.databinding.SettingFragmentBinding

class SettingFragment : Fragment(R.layout.setting_fragment) {
    private var mBinding: SettingFragmentBinding? = null
    private val binding get() = mBinding!!
    private val weekend: Int = 3
    private val current: Int = 3

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = SettingFragmentBinding.bind(view)
    }
}
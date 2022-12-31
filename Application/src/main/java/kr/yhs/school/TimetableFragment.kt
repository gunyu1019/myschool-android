package kr.yhs.school

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Space
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import kr.yhs.school.databinding.TimetableFragmentBinding
import kotlin.math.roundToInt

class TimetableFragment : Fragment(R.layout.timetable_fragment) {
    private var mBinding: TimetableFragmentBinding? = null
    private val binding get() = mBinding!!
    private val weekend: Int = 3
    private val current: Int = 3

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = TimetableFragmentBinding.bind(view)

        binding.timetableTable.addView(
            createTableRow(0, arrayListOf("수학", "수학", "수학", "수학", "프로그래밍"))
        )
        binding.timetableTable.addView(
            createTableRow(1, arrayListOf("독서", "독서", "독서", "인공지능", "지구과학II"))
        )
        binding.timetableTable.addView(
            createTableRow(2, arrayListOf("독서", "독서", "독서", "인공지능", "지구과학II"))
        )
        binding.timetableTable.addView(
            createTableRow(3, arrayListOf("독서", "독서", "독서", "인공지능", "지구과학II"))
        )
        binding.timetableTable.addView(
            createTableRow(4, arrayListOf("독서", "독서", "독서", "인공지능", "지구과학II"))
        )
        binding.timetableTable.addView(
            createTableRow(5, arrayListOf("독서", "독서", null, "인공지능", "지구과학II"))
        )
        binding.timetableTable.addView(
            createTableRow(6, arrayListOf("독서", "독서", "독서", null, "지구과학II"))
        )
    }

    private fun createTableRow(position: Int, subject: ArrayList<String?>): TableRow {
        val newRow = TableRow(this.context)
        newRow.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.MATCH_PARENT
        )
        newRow.gravity = Gravity.CENTER
        val textView = TextView(this.context)
        textView.text = context?.getString(R.string.timetable_time, position + 1)
        textView.gravity = Gravity.CENTER
        textView.setPadding(
            convertSize(this.requireContext(), 8)
        )
        newRow.addView(textView)
        for (i in 0..4) {
            newRow.addView(
                createTextView(subject[i], (i == weekend), (i == weekend && position == current)),
            )
        }
        return newRow
    }

    private fun createTextView(subject: String?, weekend: Boolean = false, current: Boolean = false): View {
        if (subject != null) {
            val textView = TextView(this.context)
            when {
                current -> textView.background = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.background_box_v3_superbold
                )
                weekend -> textView.background = AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.background_box_v3_bold
                )
                else -> textView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.background_box_v3)
            }
            textView.gravity = Gravity.CENTER
            textView.layoutParams = TableRow.LayoutParams(
                convertSize(this.requireContext(), 80),
                convertSize(this.requireContext(), 80)
            )
            textView.setPadding(
                convertSize(this.requireContext(), 10)
            )
            if (current)
                textView.setTypeface(null, Typeface.BOLD)
            textView.text = subject
            return textView
        } else {
            val space = Space(this.context)
            space.layoutParams = TableRow.LayoutParams(
                convertSize(this.requireContext(), 80),
                convertSize(this.requireContext(), 80)
            )
            space.setPadding(
                convertSize(this.requireContext(), 10)
            )
            return space
        }
    }

    private fun convertSize(context: Context, dp: Int): Int {
        val density: Float = context.resources.displayMetrics.density
        return (dp.toFloat() * density).roundToInt()
    }
}
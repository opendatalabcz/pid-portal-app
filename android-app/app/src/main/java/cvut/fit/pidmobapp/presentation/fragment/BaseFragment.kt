package cvut.fit.pidmobapp.presentation.fragment

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract val name: String
    abstract val bottomSheetState: Int
}
package cvut.fit.pidmobapp.domain.viewmodel

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import cvut.fit.pidmobapp.App
import org.koin.core.component.KoinComponent

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    KoinComponent {
    fun getContext() = getApplication<cvut.fit.pidmobapp.App>()
    fun getString(@StringRes id: Int): String = getContext().getString(id)
}
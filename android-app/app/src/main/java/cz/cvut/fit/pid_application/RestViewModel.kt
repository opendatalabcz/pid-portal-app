package cz.cvut.fit.pid_application

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.cvut.fit.pid_application.model.Delay
import cz.cvut.fit.pid_application.model.User
import cz.cvut.fit.pid_application.network.DelayNetwork
import cz.cvut.fit.pid_application.network.UserNetwork
import kotlinx.coroutines.launch

class RestViewModel : ViewModel() {

    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    val delay: MutableLiveData<Delay> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserNetwork.retrofit.getPost()
        }
    }

    fun getDelay() {
        viewModelScope.launch {
            delay.value = DelayNetwork.retrofit.getDelay()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserNetwork.retrofit.getPosts()
        }
    }

}
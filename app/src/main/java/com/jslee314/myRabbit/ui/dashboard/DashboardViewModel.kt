package com.jslee314.myRabbit.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jslee314.myRabbit.AppApplication
import com.jslee314.myRabbit.DevByteNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class DashboardViewModel(val appApplication: AppApplication) : ViewModel() {

    private var _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    private var _url = MutableLiveData<String>()
    val url: LiveData<String>
        get() = _url

    init {
        refreshData()
    }

    private fun refreshData() {
        viewModelScope.launch {
            try {
                refreshVideos()
            } catch (networkError: IOException) {
                // Show a Toast error message and hide the progress bar.
            }
        }
    }


    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            _title.postValue(DevByteNetwork.devbytes.getPlaylist().videos[0].title)
           // _url.value = DevByteNetwork.devbytes.getPlaylist().videos[0].url

        }
    }


}

class DashboardViewModelFactory(val appApplication: AppApplication) : ViewModelProvider.Factory {
    // ViewModelProvider.Factory를 확장함.
    // 오버라이드 하면 아래와 같은 create 함수를 받을 수 있음.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // modelClass에 MainActivityViewModel이 상속이 되었나요? 라고 물어봅니다.
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            // 맞다면 MainViewModel의 파라미터 값을 넘겨주죠.
            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(appApplication) as T
        }
        // 상속이 되지 않았다면 IllegalArgumentException을 통해 상속이 되지 않았다는 에러를 띄웁니다
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
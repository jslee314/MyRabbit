package com.jslee314.myRabbit.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var _progressBarHP = MutableLiveData<Int>()
    val progressBarHP: LiveData<Int>
        get() = _progressBarHP

    private var _progressBarMP = MutableLiveData<Int>()
    val progressBarMP: LiveData<Int>
        get() = _progressBarMP

    private var _progressBarSP = MutableLiveData<Int>()
    val progressBarSP: LiveData<Int>
        get() = _progressBarSP

    init {
        _progressBarHP.value = 20
        _progressBarMP.value = 70
        _progressBarSP.value = 80
    }

}
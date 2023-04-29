package com.jslee314.myRabbit.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.room.Database
import com.jslee314.myRabbit.model.POWER
import com.jslee314.myRabbit.model.Point
import com.jslee314.myRabbit.model.PointDao
import com.jslee314.myRabbit.model.RoomDB

class MainViewModel(
    //val roomDB: RoomDB
    ) : ViewModel() {

   // private val pointList: LiveData<List<Point>> = roomDB.pointDao().getPoint().asLiveData()

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
//        for(point in pointList.value!!){
//            when(point.power){
//                POWER.HP -> _progressBarHP.value = point.pointValue
//                POWER.MP -> _progressBarMP.value = point.pointValue
//                POWER.SP -> _progressBarSP.value = point.pointValue
//            }
//        }
    }

}

//class MainViewModelFactory(private val roomDB: RoomDB) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return MainViewModel(roomDB) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
package com.jslee314.myRabbit

import android.app.Application
import com.jslee314.myRabbit.model.PointDao
import com.jslee314.myRabbit.model.RoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppApplication: Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { RoomDB.getDatabase(this, applicationScope) }

//    val repository by lazy { WordRepository(database.wordDao()) }
}
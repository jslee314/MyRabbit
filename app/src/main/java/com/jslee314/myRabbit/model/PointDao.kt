package com.jslee314.myRabbit.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PointDao {
    @Query("SELECT * FROM point_table ORDER BY power ASC")
    fun getAlphabetizedPoint(): Flow<List<Point>>
}
package com.jslee314.myRabbit.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PointDao {
    @Query("SELECT * FROM point_table")
    fun getPoint(): Flow<List<Point>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(point: Point)

    @Query("DELETE FROM point_table")
    suspend fun deleteAll()
}
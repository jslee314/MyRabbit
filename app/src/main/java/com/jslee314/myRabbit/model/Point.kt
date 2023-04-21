package com.jslee314.myRabbit.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_table")
data class Point (
    @PrimaryKey @ColumnInfo(name = "power")
    val power: POWER,
    val point: String,
    var pointValue: Int,
)
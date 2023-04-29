package com.jslee314.myRabbit.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_table")
data class Point (
    @PrimaryKey @ColumnInfo(name = "point")
    val point: String,
    val power: POWER,
    val pointValue: Int
)


//data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)

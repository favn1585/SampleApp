package com.example.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "lesson_result_table")
data class LessonResultDto(
    @ColumnInfo(name = "id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "uri") val startTime: Long,
    @ColumnInfo(name = "createdDate") val endTime: Long
)
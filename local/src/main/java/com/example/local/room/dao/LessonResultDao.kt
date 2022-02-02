package com.example.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.local.room.entity.LessonResultDto

@Dao
interface LessonResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(content: LessonResultDto)
}
package com.example.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.local.room.dao.LessonResultDao
import com.example.local.room.entity.LessonResultDto

@Database(
    entities = [LessonResultDto::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun lessonResultDao(): LessonResultDao
}
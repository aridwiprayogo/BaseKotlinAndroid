package com.pratamawijaya.basekotlin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pratamawijaya.basekotlin.data.database.dao.ArticleDao
import com.pratamawijaya.basekotlin.data.database.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}
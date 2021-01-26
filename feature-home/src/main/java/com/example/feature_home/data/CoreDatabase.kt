package com.example.feature_home.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feature_home.data.persistance.dao.RefferalDao
import com.example.feature_home.data.persistance.entity.RefferalList



@Database(
    entities = [RefferalList::class],
    version = 2
)

internal abstract class CoreDatabase : RoomDatabase(){

    abstract fun refferalDao() : RefferalDao
}
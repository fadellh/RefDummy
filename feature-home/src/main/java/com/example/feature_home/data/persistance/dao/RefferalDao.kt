package com.example.feature_home.data.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.feature_home.data.persistance.entity.RefferalList
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RefferalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRefferal(ref: RefferalList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertRefferalToRoom(ref: List<RefferalList>)

    @Query("DELETE FROM RefferalList")
    suspend fun deleteRefferal() : Int

    @Query("SELECT * FROM RefferalList ORDER BY id DESC")
    abstract fun getAllRefferalAsFlow(): Flow<List<RefferalList>>

    @Transaction
     suspend fun replaceAllReferral(entities:List<RefferalList>){
        deleteRefferal()
        insertRefferalToRoom(entities)
    }
}
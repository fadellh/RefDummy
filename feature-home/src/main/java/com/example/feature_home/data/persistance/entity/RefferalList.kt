package com.example.feature_home.data.persistance.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RefferalList")
internal data class RefferalList (
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val patientName: String,
        val status: Int
)
/*{
        @PrimaryKey(autoGenerate = true)
        val id : Int? = null
}*/


internal fun RefferalList.toDomain() =
        com.example.feature_home.data.domain.RefferalList(
                patient_name = patientName,
                status = status
        )

package com.example.feature_home.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
internal object DataModule {

    @Singleton
    @Provides
    fun provideCoreDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        CoreDatabase::class.java,
        REFFERAL_DATABASE
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun refferalDao(db:CoreDatabase) = db.refferalDao()

}

private const val REFFERAL_DATABASE = "refferal_db"
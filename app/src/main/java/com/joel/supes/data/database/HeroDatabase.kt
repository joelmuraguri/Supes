package com.joel.supes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [HeroEntity::class],
    exportSchema = false,
    version = 1
)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao() : HeroDao

    companion object{

        @Volatile
        var INSTANCE : HeroDatabase ?= null

        fun getDatabaseInstance(
            context: Context
        ) : HeroDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    HeroDatabase::class.java,
                    "Hero_Dataase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
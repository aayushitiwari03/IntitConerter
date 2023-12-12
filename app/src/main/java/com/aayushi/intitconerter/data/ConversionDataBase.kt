package com.aayushi.intitconerter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [ConversionResult::class],
    version = 1,
    exportSchema = false
)
abstract class ConversionDataBase : RoomDatabase(){

    abstract val getConverterDao: ConverterDao

    companion object{
        @Volatile
        private var INSTANCE: ConversionDataBase? = null
        fun getInstance(context: Context): ConversionDataBase {
            synchronized(this){
                var instance = INSTANCE
                    if(instance == null){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            ConversionDataBase::class.java,
                            "converter_database"
                        ).build()
                    }
                return instance
            }
        }
    }
}
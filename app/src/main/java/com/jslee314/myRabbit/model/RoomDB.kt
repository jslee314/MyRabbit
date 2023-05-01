package com.jslee314.myRabbit.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Point::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun pointDao(): PointDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): RoomDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.pointDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(pointDao: PointDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            pointDao.deleteAll()

            var point = Point("HP", POWER.HP, 90)
            pointDao.insert(point)
            point = Point("MP", POWER.MP, 30)
            pointDao.insert(point)
            point = Point("SP", POWER.SP, 60)
            pointDao.insert(point)

            val pointList: LiveData<List<Point>> = pointDao.getPoint().asLiveData()
            Log.d("jsleeeee","pointList" + pointList)
        }
    }
}

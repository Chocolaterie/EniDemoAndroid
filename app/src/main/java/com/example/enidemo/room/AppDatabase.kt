package com.example.enidemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.enidemo.model.Person

@Database(entities = arrayOf(Person::class, Player::class, Inventory::class, Item::class, QuestPlayer::class, Quest::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Les DAO
    abstract fun personDao(): DAOPerson
    abstract fun playerDao(): DAOPlayer

    // Le singleton
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Fonction pour récupérer le singleton
        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java
                ).allowMainThreadQueries().build()
                INSTANCE = instance
            }
            return instance
        }
    }
}

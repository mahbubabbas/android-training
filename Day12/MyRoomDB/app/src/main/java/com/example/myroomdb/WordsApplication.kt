package com.example.myroomdb

import android.app.Application
import com.example.myroomdb.db.WordRepository
import com.example.myroomdb.db.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}

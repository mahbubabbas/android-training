package com.example.myroomdb.db

import androidx.annotation.WorkerThread
import com.example.myroomdb.db.Word
import com.example.myroomdb.db.WordDao

class WordRepository(private val wordDao: WordDao) {
    val allWords = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

    @WorkerThread
    suspend fun deleteAll() {
        wordDao.deleteAll()
    }
}

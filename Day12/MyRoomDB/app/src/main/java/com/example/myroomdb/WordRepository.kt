package com.example.myroomdb

import androidx.annotation.WorkerThread

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

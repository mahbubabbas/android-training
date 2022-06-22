package com.example.myroomdb.db

import androidx.room.*
import com.example.myroomdb.db.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word DESC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word) : Unit

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}


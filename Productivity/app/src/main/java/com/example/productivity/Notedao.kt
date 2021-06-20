package com.example.productivity

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Notedao {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insert(Note:Note)

    @Delete
    suspend  fun delete(Note:Note)
    @Query("Select * from my_table order by Id ASC")
    fun showall():LiveData<List<Note>>
}
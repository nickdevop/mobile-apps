package com.example.productivity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="my_table")
data class Note(@ColumnInfo(name="Note")val Note:String)
{
    @PrimaryKey(autoGenerate = true) var Id:Int=0;
}
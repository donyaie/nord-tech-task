package com.nordpass.tt.storage.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TodoDao.TABLE_NAME)
internal class TodoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val isCompleted: Boolean,
    val createdAt: String,
    val userId: Int,
    val updatedAt: String
)
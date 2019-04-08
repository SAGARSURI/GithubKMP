package com.example.presentation

import com.example.models.Member

interface DataRepository {
    val members: List<Member>?
    var onRefreshListener: List<() -> Unit>
    suspend fun update()
}
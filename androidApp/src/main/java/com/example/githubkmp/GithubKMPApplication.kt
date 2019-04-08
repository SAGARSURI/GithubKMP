package com.example.githubkmp

import android.app.Application
import com.example.api.GithubApi
import com.example.models.MemberDataRepository
import com.example.presentation.DataRepository

class GithubKMPApplication: Application() {
    val repository: DataRepository by lazy {
        MemberDataRepository(GithubApi())
    }
}
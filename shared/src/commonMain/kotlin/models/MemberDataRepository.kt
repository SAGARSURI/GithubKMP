package com.example.models

import com.example.api.GithubApi
import com.example.UpdateProblem
import com.example.presentation.DataRepository

class MemberDataRepository(private val api: GithubApi): DataRepository{
    override var members: List<Member>? = null
    override var onRefreshListener: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        }catch (cause: Throwable){
            throw UpdateProblem()
        }
        if(newMembers!=members){
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners(){
        onRefreshListener.forEach { it() }
    }

}
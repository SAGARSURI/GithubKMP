package com.example.api

import com.example.models.Member
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.Url
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class GithubApi {
    private val client = HttpClient()
    private val memberUrl = Url("https://api.github.com/orgs/mutualmobile/members")
    suspend fun getMembers(): List<Member> {
        return Json.nonstrict.parse(Member.serializer().list,
            client.get {
                url(memberUrl.toString())
            })
    }
}
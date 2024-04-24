package org.jason.service

import io.ktor.client.call.body
import io.ktor.http.cio.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.jason.utils.ktor.HttpClientManager

class MemberService {
    val client = HttpClientManager()

    suspend inline fun <reified T> existsUserId(userId: String) {
        val response = client.get("/exists-userId")

    }
}
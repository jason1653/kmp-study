package org.jason.utils.ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.HttpResponse
import io.ktor.http.contentType
import io.ktor.util.InternalAPI

class HttpClientManager {
    private val baseURL = ""


    val client: HttpClient = HttpClient {

        install (Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install (HttpTimeout) {
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 30000
        }

        defaultRequest {
            url(baseURL)
        }
    }

    suspend fun get(endpoint: String): HttpResponse {
        return client.get(endpoint)
    }

    suspend fun post(endpoint: String, body: Any): HttpResponse {
        return client.post(endpoint) {
            contentType(io.ktor.http.ContentType.Application.Json)
        }
    }
    suspend fun put(endpoint: String): HttpResponse {
        return client.put(endpoint)
    }

    suspend fun delete(endpoint: String): HttpResponse {
        return client.delete(endpoint)
    }
}
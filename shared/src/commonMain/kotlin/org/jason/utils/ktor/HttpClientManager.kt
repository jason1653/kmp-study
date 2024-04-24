package org.jason.utils.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class HttpClientManager {
    private val baseURL = "http://localhost:8081"


    val client: HttpClient = HttpClient(CIO) {
        expectSuccess = true
        HttpResponseValidator {
            validateResponse { response ->
                if (response.status == HttpStatusCode.BadRequest) {
                    val errorResponse = Json.decodeFromString<ErrorResponse>(response.bodyAsText())
                    println(errorResponse.message)
                    throw Exception(errorResponse.message.toString())
                }
            }

            handleResponseExceptionWithRequest { exception, request ->
                if (exception is ResponseException) {
                    val status = exception.response.status
                    val responseException = exception.response.body<ErrorResponse>()
                    throw Exception(responseException.message as String)
//                    throw ResponseException(exception.response, "Received HTTP status code ${exception.response.status.value}")
                }

            }
        }

        install(ContentNegotiation) {
            json()
        }



        install (Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install (HttpTimeout) {
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 30000
        }

        install(DefaultRequest) {
            url(baseURL)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }



    }

    @Throws(Exception::class)
    suspend inline fun <reified T> get(endpoint: String): T {

        val response = client.get(endpoint)
        print(response.body())
        return response.body()
    }

    suspend fun post(endpoint: String, body: Any): HttpResponse {
        return client.post(endpoint)
    }
    suspend fun put(endpoint: String): HttpResponse {
        return client.put(endpoint)
    }

    suspend fun delete(endpoint: String): HttpResponse {
        return client.delete(endpoint)
    }
}
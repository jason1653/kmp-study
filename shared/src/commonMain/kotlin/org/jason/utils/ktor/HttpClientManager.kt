package org.jason.utils.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.Parameters
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class HttpClientManager {
    private val baseURL = "http://localhost:8081"


    val client: HttpClient = HttpClient(CIO) {
        expectSuccess = true
        HttpResponseValidator {
            validateResponse { response ->
                if (!response.status.isSuccess()) { // Generalized for all non-success responses
                    val responseBody = response.bodyAsText()
                    val errorResponse = try {
                        Json.decodeFromString<ErrorResponse>(responseBody)
                    } catch (e: Exception) {
                        null
                    }
                    throw ErrorResponseException(
                        code = errorResponse?.code,
                        message = errorResponse?.message,
                        status = response.status,
                        body = responseBody
                    )
                }
            }


            /*
            handleResponseExceptionWithRequest { exception, _ ->
                if (exception is ResponseException) {
                    val status = exception.response.status
                    val responseBody = exception.response.bodyAsText()
                    val errorResponse = try {
                        Json.decodeFromString<ErrorResponse>(responseBody)
                    } catch (e: Exception) {
                        null
                    }

                    println("ErrorResponseException")
                    throw ErrorResponseException(
                        code = errorResponse?.code,
                        message = errorResponse?.message,
                        status = status,
                        body = responseBody
                    )
                }
            }

             */
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

    suspend inline fun <reified R> get(endpoint: String, query: Parameters? = null): ApiResponse<R> {
        return try {
            client.get(endpoint) {
                if (query != null) {
                    url.parameters.appendAll(query)
                }
            }.body() as ApiResponse<R>
        } catch (e: ErrorResponseException) {


            ApiResponse<R>(
                code = "000",
                message = "1111",
                status = 200,
                body = e.message

            )
        }
    }

    suspend inline fun <reified T, reified R>  post(endpoint: String, requestBody: T): R {
        return client.post(endpoint) {
            setBody(requestBody)
        }.body()
    }
    suspend fun put(endpoint: String): HttpResponse {
        return client.put(endpoint)
    }

    suspend fun delete(endpoint: String): HttpResponse {
        return client.delete(endpoint)
    }




}
package org.jason.service

import io.ktor.http.Parameters
import org.jason.domain.admin.users.request.CreateUserRequest
import org.jason.domain.admin.users.UserListData
import org.jason.domain.admin.users.response.CreateUserResponse
import org.jason.utils.ktor.ApiResponse
import org.jason.utils.ktor.HttpClientManager

class MemberService {
    val client = HttpClientManager()


    @Throws(Exception::class)
    suspend fun existsUserId(userId: String): ApiResponse<Boolean> {
        val queryParams = Parameters.build {
            append("userId", userId)
        }
        return client.get<ApiResponse<Boolean>>("/member-service/users/exists-userId", queryParams)
    }

    @Throws(Exception::class)
    suspend fun createUser(body: CreateUserRequest): ApiResponse<CreateUserResponse> {
        return client.post<CreateUserRequest, ApiResponse<CreateUserResponse>>("/member-service/users/create", body)
    }

    @Throws(Exception::class)
    suspend fun adminUserList(): ApiResponse<UserListData> {
        return client.get<ApiResponse<UserListData>>("/admin/member-service/users?page=1&pageSize=10")
    }
}
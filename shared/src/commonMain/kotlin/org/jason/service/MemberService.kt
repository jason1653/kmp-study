package org.jason.service

import org.jason.domain.admin.users.UserListData
import org.jason.utils.ktor.ApiResponse
import org.jason.utils.ktor.HttpClientManager

class MemberService {
    val client = HttpClientManager()


    @Throws(Exception::class)
    suspend fun existsUserId(userId: String): ApiResponse<Boolean> {
        return client.get<ApiResponse<Boolean>>("/member-service/users/exists-userId")
    }


    @Throws(Exception::class)
    suspend fun adminUserList(): ApiResponse<UserListData> {
        return client.get<ApiResponse<UserListData>>("/admin/member-service/users?page=1&pageSize=10")
    }
}
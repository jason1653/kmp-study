package org.jason.domain.admin.users

import kotlinx.serialization.Serializable


@Serializable
data class UserListData(
    val total: Int,
    val totalPage: Int,
    val users: ArrayList<UserData>
) {
    @Serializable
    data class UserData(
        val uid: String,
        val userId: String,
        val userName: String,
        val nickName: String,
        val statusNm: String,
        val gradeNm: String,
        val point: Int,
        val gender: String,
        val phoneNumber: String,
        val email: String,
        val lastLoginDatetime: String,
        val registDatetime: String
    )
}

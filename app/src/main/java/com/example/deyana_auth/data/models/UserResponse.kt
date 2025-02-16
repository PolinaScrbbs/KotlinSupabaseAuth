package com.example.deyana_auth.data.models

import java.util.UUID

data class UserResponse(
    val id: UUID,
    val email: String,
    val password: String
)

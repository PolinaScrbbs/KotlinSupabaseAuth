package com.example.deyana_auth.data.api
import com.example.deyana_auth.data.models.UserRequest
import com.example.deyana_auth.data.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNvYmpqbHF1cXB4bHlkamdlcXZ4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzk3MDc4MDUsImV4cCI6MjA1NTI4MzgwNX0.cgfl7wSuzItIgf0dClSCFSVmMVwndmHkO9Ei9FTuPpI",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNvYmpqbHF1cXB4bHlkamdlcXZ4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzk3MDc4MDUsImV4cCI6MjA1NTI4MzgwNX0.cgfl7wSuzItIgf0dClSCFSVmMVwndmHkO9Ei9FTuPpI",
        "Content-Type: application/json"
    )
    @POST("rest/v1/users")
    fun registerUser(@Body user: UserRequest): Call<Void>

    @Headers(
        "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNvYmpqbHF1cXB4bHlkamdlcXZ4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzk3MDc4MDUsImV4cCI6MjA1NTI4MzgwNX0.cgfl7wSuzItIgf0dClSCFSVmMVwndmHkO9Ei9FTuPpI",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNvYmpqbHF1cXB4bHlkamdlcXZ4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzk3MDc4MDUsImV4cCI6MjA1NTI4MzgwNX0.cgfl7wSuzItIgf0dClSCFSVmMVwndmHkO9Ei9FTuPpI",
        "Content-Type: application/json"
    )
    @GET("rest/v1/users")
    fun getUserByEmail(
        @Query("email") email: String,
        @Query("select") select: String = "*"
    ): Call<List<UserResponse>>

}
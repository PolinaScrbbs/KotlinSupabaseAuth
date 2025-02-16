package com.example.deyana_auth.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deyana_auth.R
import com.example.deyana_auth.data.models.UserResponse
import com.example.deyana_auth.network.RetrofitClient
import com.example.deyana_auth.ui.register.RegisterActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewSignUp = findViewById(R.id.textViewSignUp)

        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }

        textViewSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        RetrofitClient.instance.getUserByEmail("eq.${email}").enqueue(object : Callback<List<UserResponse>> {
            override fun onResponse(call: Call<List<UserResponse>>, response: Response<List<UserResponse>>) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    val user = response.body()!!.first()

                    if (user.password == password) {
                        Log.d("LoginActivity", "Пользователь найден: ${user.email}")
                        Toast.makeText(this@LoginActivity, "Логин успешен!", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("LoginActivity", "Неверный пароль")
                        Toast.makeText(this@LoginActivity, "Неверный пароль", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.d("LoginActivity", "Пользователь не найден ${response}")
                    Toast.makeText(this@LoginActivity, "Пользователь не найден", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                Log.e("LoginActivity", "Ошибка сети: ${t.message}")
            }
        })
    }




}
package com.leaftware.dental.clinic.domain

import com.leaftware.dental.clinic.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginUseCase(private val apiService: ApiService) {
    suspend fun setLogin(username: String, password: String): Boolean {

        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.login(username, password)
                return@withContext response.isSuccessful
            } catch (e: IOException) {
                return@withContext false
            } catch (e: HttpException) {
                return@withContext false
            }
        }
    }
}
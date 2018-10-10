package com.newsapp.ui.main.detail.acts

import com.newsapp.api.ApiService
import javax.inject.Inject

class GetUserByNameAct @Inject constructor(
        private val apiService: ApiService) {

    fun execute(userName: String) = apiService.getUser(userName)
}

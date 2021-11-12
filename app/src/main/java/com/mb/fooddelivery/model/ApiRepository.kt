package com.mb.fooddelivery.model

import com.mb.fooddelivery.model.data.login.LoginRequest
import com.mb.fooddelivery.model.local.LocalDataSource
import com.mb.fooddelivery.model.remote.RemoteDataSource
import com.mb.fooddelivery.utils.networkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private var localDataSource: LocalDataSource
) {

    fun login(request: LoginRequest) = networkOperation(
        call = {
            remoteDataSource.loginRequest(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )
}
package com.example.guidemknew.helpers

import com.example.core.data.MainDataSource
import com.example.guidemknew.di.LocalVersion
import com.example.guidemknew.di.NetworkVersion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class VersionHelper @Inject constructor(
    @LocalVersion private val localDataSource: MainDataSource,
    @NetworkVersion private val networkDataSource: MainDataSource,
) {
    private val scopeIo = CoroutineScope(Dispatchers.IO)

    suspend fun isCorrectVersion():Boolean{
        return false
//        scopeIo.launch {
//            val firstVersion = firstDataSource.getVersion()
//            val secondVersion = secondDataSource.getVersion()
//        }
    }
}
package com.example.guidemknew.data

import com.example.core.data.MainDataSource

class PreferenceDataSource:MainDataSource {

    override suspend fun getVersion(): Double {
        return 1.2
    }

    override suspend fun saveVersion() {

    }
}
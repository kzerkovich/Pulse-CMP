package org.kzerkovich.pulse.features.login.data

interface AuthLocalDataStore {
    suspend fun checkToken(): String
}

class AuthEncryptedDataSource(): AuthLocalDataStore {
    override suspend fun checkToken(): String {
        return ""
    }

}
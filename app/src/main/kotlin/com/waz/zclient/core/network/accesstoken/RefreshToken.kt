package com.waz.zclient.core.network.accesstoken

import com.google.gson.annotations.SerializedName
import com.waz.zclient.core.extension.empty
import org.threeten.bp.Instant

data class RefreshToken(val token: String) {

    val expiryDate by lazy { calculateExpiryDate() }

    private fun calculateExpiryDate(): Instant? {
        val parts = token.split('.')
        val datePart = parts.find { it.contains("d=") }?.drop(2)
        return datePart?.toLong()?.let { Instant.ofEpochSecond(it) }
    }

    companion object {
        val EMPTY = RefreshToken(String.empty())
    }
}

data class RefreshTokenPreference(
    @SerializedName("token")
    val token: String
)

class RefreshTokenMapper {
    fun fromTokenText(tokenText: String) = RefreshToken(tokenText)

    fun from(pref: RefreshTokenPreference) = RefreshToken(pref.token)

    fun toPreference(refreshToken: RefreshToken) = RefreshTokenPreference(refreshToken.token)
}

package com.waz.zclient.core.network.accesstoken

import com.waz.zclient.core.extension.empty
import com.waz.zclient.core.network.api.token.AccessTokenResponse

data class AccessToken(
    val token: String,
    val tokenType: String,
    val expiresIn: String
) {
    companion object {
        val EMPTY = AccessToken(String.empty(), String.empty(), String.empty())
    }
}

class AccessTokenMapper {
    fun from(preference: AccessTokenPreference) = AccessToken(
        token = preference.token,
        tokenType = preference.tokenType,
        expiresIn = preference.expiresIn
    )

    fun from(response: AccessTokenResponse) = AccessToken(
        token = response.token,
        tokenType = response.type,
        expiresIn = response.expiresIn
    )

    fun toPreference(accessToken: AccessToken) = AccessTokenPreference(
        token = accessToken.token,
        tokenType = accessToken.tokenType,
        expiresIn = accessToken.expiresIn
    )
}

package com.waz.zclient.core.network.accesstoken

import com.waz.zclient.UnitTest
import com.waz.zclient.core.network.accesstoken.AccessTokenRemoteDataSource
import com.waz.zclient.core.network.api.token.TokenService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify

class AccessTokenRemoteDataSourceTest : UnitTest() {

    @Mock
    private lateinit var tokenService: TokenService

    private lateinit var remoteDataSource: AccessTokenRemoteDataSource

    @Before
    fun setUp() {
        remoteDataSource = AccessTokenRemoteDataSource(tokenService)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `given a refresh token, when renewAccessToken is called, calls tokenService with refresh token`() =
        runBlockingTest {
            val refreshToken = "testRefreshToken"
            remoteDataSource.renewAccessToken(refreshToken)
            verify(tokenService).renewAccessToken(refreshToken)
        }
}

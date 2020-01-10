package com.waz.zclient.user.domain.usecase

import com.waz.zclient.eq
import com.waz.zclient.user.data.UsersRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ChangeHandleUseCaseTest {

    private lateinit var changeHandleUseCase: ChangeHandleUseCase

    @Mock
    private lateinit var userRepository: UsersRepository

    @Mock
    private lateinit var changeHandleParams: ChangeHandleParams

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        changeHandleUseCase = ChangeHandleUseCase(userRepository)
    }

    @Test
    fun `Given update handle use case is executed, then the repository should update handle`() = runBlockingTest {
        `when`(changeHandleParams.handle).thenReturn(TEST_HANDLE)

        changeHandleUseCase.run(changeHandleParams)

        verify(userRepository).changeHandle(eq(TEST_HANDLE))
    }

    companion object {
        const val TEST_HANDLE = "@wire"
    }
}

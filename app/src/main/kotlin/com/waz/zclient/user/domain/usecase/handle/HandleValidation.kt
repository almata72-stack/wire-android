package com.waz.zclient.user.domain.usecase.handle

import com.waz.zclient.core.exception.FeatureFailure

object HandleTooLong : ValidateHandleError()
object HandleTooShort : ValidateHandleError()
object HandleInvalid : ValidateHandleError()
object HandleALreadyExists : ValidateHandleError()
object HandleEmptyError : ValidateHandleError()
object HandleSameAsCurrent : ValidateHandleError()
object HandleIsAvailable : ValidateHandleSuccess()
object UnknownError : ValidateHandleError()

sealed class ValidateHandleSuccess
sealed class ValidateHandleError : FeatureFailure()
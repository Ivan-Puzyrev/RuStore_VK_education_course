package com.ivanpuzyrev.rustorevkeducationcourse.data.utils

import com.ivanpuzyrev.rustorevkeducationcourse.domain.DataError.Network
import com.ivanpuzyrev.rustorevkeducationcourse.domain.Result
import retrofit2.HttpException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T> safeCall(
    execute: suspend () -> T
): Result<T, Network> = try {
    Result.Success(execute())
} catch (e: CancellationException) {
    throw e
} catch (e: HttpException) {
    Result.Failure(e.code().toNetworkError())
} catch (e: IOException) {
    Result.Failure(Network.NO_INTERNET)
} catch (e: Throwable) {
    Result.Failure(Network.UNKNOWN)
}

fun Int.toNetworkError(): Network = when (this) {
    401 -> Network.UNAUTHORIZED
    404 -> Network.NOT_FOUND
    408 -> Network.REQUEST_TIMEOUT
    429 -> Network.TOO_MANY_REQUESTS
    in 500..599 -> Network.SERVER_ERROR
    else -> Network.UNKNOWN
}
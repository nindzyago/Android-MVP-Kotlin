package ru.antipiev.ktemplate.data.api.endpoints

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import ru.antipiev.ktemplate.data.models.ApiResponse

interface Sample {

    @PUT("/api/v3/devices/{DeviceID}/")
    fun activate(@Path("DeviceID") deviceId: String)
            : Deferred<ApiResponse<String>>
    @GET("https://api.chucknorris.io/jokes/categories")
    fun list(): Deferred<List<String>>
}

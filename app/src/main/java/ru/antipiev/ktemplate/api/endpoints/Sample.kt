package ru.antipiev.ktemplate.api.endpoints

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import ru.antipiev.ktemplate.data.models.ApiResponse
import ru.antipiev.ktemplate.data.models.Item

interface Sample {

    @PUT("/api/v3/devices/{DeviceID}/")
    fun activate(@Path("DeviceID") deviceId: String)
            : Deferred<ApiResponse<String>>
    @GET("/bins/enaz0")
    fun list(): Deferred<List<Item>>
}

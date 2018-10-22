package ru.antipiev.ktemplate.data.models

import com.google.gson.annotations.SerializedName

class ApiResponse<T> {
    var status: String? = null
    @SerializedName("statusCode")
    var statusCode: String? = null
    @SerializedName("status_msg")
    var statusMsg: String? = null
    @SerializedName("data")
    var data: T? = null
        private set

    fun setDate(data: T) {
        this.data = data
    }
}

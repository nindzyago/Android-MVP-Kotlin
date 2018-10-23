package ru.antipiev.ktemplate.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.antipiev.ktemplate.Const
import ru.antipiev.ktemplate.api.endpoints.Sample


const val NO_AUTHORIZED = 401

class RestApi {

    val sample: Sample
    private val retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        val tokenInterceptor = TokenAppendingHeaderInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(tokenInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()


        retrofit = Retrofit.Builder().baseUrl(Const.Api.URL_TEST)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        sample = retrofit.create(Sample::class.java)
    }

    private inner class TokenAppendingHeaderInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            val request = chain.request()
            // TODO: Add token
            val token = ""
//            val token = tokenHelper.token
            val newRequest = request.newBuilder()
                    .addHeader(Const.Api.AUTHORIZATION, token)
                    .build()
            val response = chain.proceed(newRequest)
            if (response.code() == NO_AUTHORIZED) {
                // TODO: reload Application, and clear token or update token
            }
            return response
        }
    }

}

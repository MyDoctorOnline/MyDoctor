package com.oruel.testmydoc.repository.network

import android.util.Log
import com.oruel.testmydoc.data_class.ListDepartment
import com.oruel.testmydoc.data_class.Room
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*


class NetworkModule {
    private val baseUrl = "https://82.209.194.34:8877/views/"
    private lateinit var service: NetworkInterface

    fun getListDepartment() {
        if (!::service.isInitialized)
            init()
        service.getListDepartment().enqueue(object : Callback<ListDepartment> {
            override fun onResponse(
                call: Call<ListDepartment>,
                response: Response<ListDepartment>
            ) {
                Log.v("MyTagCode", response.code().toString())
                Log.v("MyTag", response.body().toString())
            }

            override fun onFailure(call: Call<ListDepartment>, t: Throwable) {
                Log.v("MyTagCode", t.message.toString())
//                Log.v("MyTag", t.)
            }
        })
    }

    fun getRoom(id:Long){
        if (!::service.isInitialized)
            init()
        service.getRoom(id).enqueue(object : Callback<Room> {
            override fun onResponse(
                call: Call<Room>,
                response: Response<Room>
            ) {
                Log.v("MyTagCode", response.code().toString())
                Log.v("MyTag", response.body().toString())
            }

            override fun onFailure(call: Call<Room>, t: Throwable) {
                Log.v("MyTagCode", t.message.toString())
//                Log.v("MyTag", t.)
            }
        })
    }

    fun init() {
        val builder = OkHttpClient.Builder()
        val sslContext = SSLContext.getDefault()
        builder.sslSocketFactory(sslContext.getSocketFactory(),
            object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                    Log.v("Tag", "f")
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                    Log.v("Tag", "f")

                }

                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()

            })
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(NetworkInterface::class.java)
    }


    private fun getUnsafeOkHttpClient(): OkHttpClient {
        return try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
                object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate?> {
                        return arrayOfNulls(0)
                    }
                }
            )

            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
            OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier(object : HostnameVerifier {
                    override fun verify(hostname: String?, session: SSLSession?): Boolean {
                        return true
                    }
                }).build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}
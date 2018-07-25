package com.ppjun.android.commonsdk.http

import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

class SSLSocketClient {

    companion object {

        fun getSSLSocketFactory(): SSLSocketFactory {
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, getTrustManagers(), SecureRandom())
            return sslContext.socketFactory
        }

        fun getTrustManagers(): Array<TrustManager> {
            return arrayOf(getTrustManager())

        }

        fun getTrustManager(): X509TrustManager {
            return MyTrustManager()
        }

        fun getHostNameVerifier(): HostnameVerifier {
            return HostnameVerifier { hostname, session ->
                true
            }
        }
    }

    class MyTrustManager : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}
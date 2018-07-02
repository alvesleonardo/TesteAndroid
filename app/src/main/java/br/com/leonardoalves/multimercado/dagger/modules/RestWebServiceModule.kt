package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.dataInfrastructure.webservices.FloatinMountainWebservice
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RestWebServiceModule {

    @Provides
    @Singleton
    fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun gMapsWebService(okHttpClient: OkHttpClient): FloatinMountainWebservice {
        val adapter = Retrofit.Builder()
                .baseUrl(FloatinMountainWebservice.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
                .build()
        return adapter.create(FloatinMountainWebservice::class.java)
    }
}
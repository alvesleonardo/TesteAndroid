package br.com.leonardoalves.dataInfrastructure

import br.com.leonardoalves.dataInfrastructure.data.entities.GoogleMapsGeocodeResponse
import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuInfrastructure
import br.com.leonardoalves.dataInfrastructure.testUtil.PredicateUtils
import br.com.leonardoalves.dataInfrastructure.webservices.FloatinMountainWebservice
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import io.reactivex.Flowable
import org.assertj.core.api.Java6Assertions
import org.junit.Before
import org.junit.Test


class GoogleMapsInfrastructureSuccessResultsTest {

    private lateinit var floatinMountainWebservice: FloatinMountainWebservice
    private lateinit var santanderHerokuInfrastructure: SantanderHerokuDomain

    @Before fun prepareWebserviceMock(){
        floatinMountainWebservice = object :FloatinMountainWebservice{
            override fun getCourseUrl(address: String): Flowable<GoogleMapsGeocodeResponse> {
                val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                val jsonAdapter = moshi.adapter(GoogleMapsGeocodeResponse::class.java)
                val blackjackHand = jsonAdapter.fromJson(WebservicesResponseMocks.exampleResult)
                return Flowable.just(blackjackHand)
            }
        }
        santanderHerokuInfrastructure = SantanderHerokuInfrastructure(floatinMountainWebservice)
    }

    @Test
    fun isAllItemsReturning(){
        val testObervable = santanderHerokuInfrastructure.queryLocation("a")
                .count()
                .test()
        testObervable
                .assertNoErrors()
                .assertValue(PredicateUtils.check({
                    Java6Assertions.assertThat(it)
                            .isEqualTo(7)
                }))
    }

    @Test
    fun allElementsContainObligatoryFields(){
        val observable = santanderHerokuInfrastructure.queryLocation("a")
                .toList()
                .test()
        observable
                .assertNoErrors()
                .assertValue(PredicateUtils.check({
                    Java6Assertions.assertThat(it)
                            .allMatch { it?.formattedAddress != null }
                }))

        observable
                .assertNoErrors()
                .assertValue(PredicateUtils.check({
                    Java6Assertions.assertThat(it)
                            .allMatch { it?.formattedAddress?.isNotEmpty()?:false }
                }))
        observable
                .assertNoErrors()
                .assertValue(PredicateUtils.check({
                    Java6Assertions.assertThat(it)
                            .allMatch { it?.geometry?.location?.lat != null}
                }))
        observable
                .assertNoErrors()
                .assertValue(PredicateUtils.check({
                    Java6Assertions.assertThat(it)
                            .allMatch { it?.geometry?.location?.lng != null}
                }))
    }
}
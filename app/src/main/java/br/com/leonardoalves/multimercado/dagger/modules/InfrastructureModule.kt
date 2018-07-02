package br.com.leonardoalves.multimercado.dagger.modules

import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuInfrastructure
import br.com.leonardoalves.dataInfrastructure.webservices.FloatinMountainWebservice
import dagger.Module
import dagger.Provides

@Module
class InfrastructureModule {
    @Provides fun googleMapsService(floatinMountainWebservice: FloatinMountainWebservice):SantanderHerokuDomain{
        return SantanderHerokuInfrastructure(floatinMountainWebservice)
    }
}
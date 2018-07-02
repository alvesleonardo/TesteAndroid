package br.com.leonardoalves.domain.interactors

import br.com.leonardoalves.dataInfrastructure.infraestructure.SantanderHerokuDomain
import br.com.leonardoalves.domain.domain.Form

class FormUseCase(private var santanderHerokuDomain: SantanderHerokuDomain) : Form {
}
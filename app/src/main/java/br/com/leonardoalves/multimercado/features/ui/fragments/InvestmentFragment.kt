package br.com.leonardoalves.multimercado.features.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentPresenter
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentView
import javax.inject.Inject

class InvestmentFragment: BaseFragment(), InvestmentView {
    @Inject
    lateinit var presenter: InvestmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_investment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter
    }
}
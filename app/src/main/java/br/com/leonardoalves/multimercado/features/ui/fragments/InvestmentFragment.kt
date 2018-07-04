package br.com.leonardoalves.multimercado.features.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.InfoItem
import br.com.leonardoalves.dataInfrastructure.data.entities.Screen
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentPresenter
import br.com.leonardoalves.multimercado.features.presenters.investmentFragment.InvestmentView
import br.com.leonardoalves.multimercado.features.ui.adapters.IncomeAdapter
import br.com.leonardoalves.multimercado.features.ui.adapters.InfoAdapter
import br.com.leonardoalves.multimercado.features.ui.widgets.LinearBars
import br.com.leonardoalves.multimercado.features.viewModels.mappers.InvestmentMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class InvestmentFragment: BaseFragment(), InvestmentView {

    lateinit var title:TextView
    lateinit var whatIs:TextView
    lateinit var incomeTable:RecyclerView
    lateinit var infoTable:RecyclerView
    lateinit var linearBar: LinearBars

    @Inject
    lateinit var presenter: InvestmentPresenter

    private lateinit var incomeTableAdapter: IncomeAdapter
    private lateinit var infoAdapter: InfoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_investment, container, false)
        title = view.findViewById(R.id.investment_title)
        whatIs = view.findViewById(R.id.what_is)
        val incomeTableLayout = LinearLayoutManager(activity)
        incomeTableAdapter = IncomeAdapter()
        incomeTable = view.findViewById<RecyclerView>(R.id.incomeTable).apply{
            setHasFixedSize(true)
            layoutManager = incomeTableLayout
            adapter = incomeTableAdapter
        }
        infoAdapter = InfoAdapter()
        val infoTableLayout = LinearLayoutManager(activity)
        infoTable = view.findViewById<RecyclerView>(R.id.extra_data_list).apply{
            setHasFixedSize(true)
            layoutManager = infoTableLayout
            adapter = infoAdapter
        }
        linearBar = view.findViewById(R.id.linearBar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getContentData()
    }

    @SuppressLint("CheckResult")
    override fun subscribe(investmentData: Single<Screen?>?) {
        if (investmentData == null){
            return
        }
        investmentData
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                {
                    title.text = it?.fundName?:""
                    whatIs.text = it?.definition?:""
                    val moreInfoToViewModel = InvestmentMapper.moreInfoToViewModel(it?.moreInfo)
                    incomeTableAdapter.addAll(moreInfoToViewModel)
                    infoAdapter.addItems(it?.info?: arrayListOf<InfoItem>(), it?.downInfo ?: arrayListOf<InfoItem>())
                    linearBar.setRating(it?.risk?:1)
                },{
                    it.printStackTrace()
                }
        )
    }
}
package br.com.leonardoalves.multimercado.features.viewModels.mappers

import br.com.leonardoalves.dataInfrastructure.data.entities.MoreInfo
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.viewModels.entities.MoreInfoViewModel

class InvestmentMapper {
    companion object {
        fun moreInfoToViewModel(moreInfo: MoreInfo?): List<MoreInfoViewModel> {
            var items: ArrayList<MoreInfoViewModel> = arrayListOf()
            if (moreInfo == null){
                return items
            }
            items.add(MoreInfoViewModel(R.string.period_month, moreInfo.month?.fund?.toString()?:"0", moreInfo.month?.cDI?.toString()?:"0"))
            items.add(MoreInfoViewModel(R.string.period_year, moreInfo.month?.fund?.toString()?:"0", moreInfo.month?.cDI?.toString()?:"0"))
            items.add(MoreInfoViewModel(R.string.period_12_months, moreInfo.month?.fund?.toString()?:"0", moreInfo.month?.cDI?.toString()?:"0"))
            return items
        }
    }
}
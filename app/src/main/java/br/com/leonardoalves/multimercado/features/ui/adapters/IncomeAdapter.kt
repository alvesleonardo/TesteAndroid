package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.viewModels.entities.MoreInfoViewModel
import androidx.core.content.res.ResourcesCompat



class IncomeAdapter : RecyclerView.Adapter<IncomeAdapter.ViewHolder>() {

    var items: ArrayList<MoreInfoViewModel> = arrayListOf()

    fun addAll(moreInfoToViewModel: List<MoreInfoViewModel>) {
        items.clear()
        items.addAll(moreInfoToViewModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_more_info_income, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0){
            holder.bindTitle()
        } else{
            holder.bind(items[position-1])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var periodField:TextView = itemView.findViewById(R.id.period)
        var foundField:TextView = itemView.findViewById(R.id.found)
        var cdiField:TextView = itemView.findViewById(R.id.cdi)

        fun bind(moreInfo: MoreInfoViewModel) {
            periodField.text = itemView.context.getString(moreInfo.period)
            val typeface = ResourcesCompat.getFont(itemView.context, R.font.din_pro_bold)
            foundField.text = moreInfo.found
            foundField.typeface = typeface
            cdiField.text = moreInfo.cdi
            cdiField.typeface = typeface
        }

        fun bindTitle() {
            periodField.text = ""
            foundField.text = itemView.context.getString(R.string.found)
            cdiField.text = itemView.context.getString(R.string.cdi)
        }

    }
}
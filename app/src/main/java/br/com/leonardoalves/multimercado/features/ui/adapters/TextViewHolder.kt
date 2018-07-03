package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R

class TextViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {
    var textView : TextView = itemView.findViewById(R.id.textView)

    fun bind(cellsItem: CellsItem){
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8, cellsItem.topSpacing?.toInt()?:0, 8, 0)
        itemView.layoutParams = lp
        textView.text = cellsItem.message
        itemView.visibility =  if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
    }
}
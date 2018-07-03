package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem

class ImageViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

    fun bind(cellsItem: CellsItem){
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8, cellsItem.topSpacing?.toInt()?:0, 8, 0)
        itemView.layoutParams = lp
        itemView.visibility = if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
    }
}
package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem

class ImageViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

    fun bind(cellsItem: CellsItem){
        itemView.visibility = if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
    }
}
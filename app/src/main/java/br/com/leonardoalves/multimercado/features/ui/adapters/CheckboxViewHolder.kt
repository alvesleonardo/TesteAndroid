package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R

class CheckboxViewHolder(itemView: View, var listener: CheckboxViewHolder.CheckboxVisibility) :  RecyclerView.ViewHolder(itemView){
    var checkbox : CheckBox = itemView.findViewById(R.id.checkbox)

    fun bind(cellsItem: CellsItem){
        checkbox.text = cellsItem.message
        itemView.visibility =  if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
        checkbox.setOnCheckedChangeListener { p0, p1 ->
            listener.setVisible(cellsItem.show, if(p1){View.VISIBLE}else{View.GONE})
        }
    }

    interface CheckboxVisibility{
        fun setVisible(show: Int?, i: Int)
    }
}
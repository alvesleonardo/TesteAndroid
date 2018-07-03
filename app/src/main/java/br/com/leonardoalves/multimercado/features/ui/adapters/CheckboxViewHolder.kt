package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R

class CheckboxViewHolder(itemView: View, var listener: CheckboxViewHolder.CheckboxVisibility) :  RecyclerView.ViewHolder(itemView){
    var checkbox : CheckBox = itemView.findViewById(R.id.checkbox)
    lateinit var cellItem: CellsItem

    fun bind(cellsItem: CellsItem){
        cellItem = cellsItem
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8, cellsItem.topSpacing?.toInt()?:0, 8, 0)
        itemView.layoutParams = lp
        checkbox.text = cellsItem.message
        itemView.visibility =  if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
        checkbox.isChecked = false
        checkbox.setOnCheckedChangeListener { p0, p1 ->
            listener.setVisible(cellsItem.show, if(p1){View.VISIBLE}else{View.GONE})
        }
    }

    fun validate(): Boolean {
        if (cellItem.required == true && !checkbox.isChecked){
            return false
        }
        return true
    }

    interface CheckboxVisibility{
        fun setVisible(show: Int?, i: Int)
    }
}
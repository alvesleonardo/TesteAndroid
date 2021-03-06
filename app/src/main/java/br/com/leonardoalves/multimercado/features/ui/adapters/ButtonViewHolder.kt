package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R
import kotlinx.android.synthetic.main.adapter_button_field.view.*

class ButtonViewHolder(itemView: View, var listener:SendButtonListener) :  RecyclerView.ViewHolder(itemView) {
    var button: Button = itemView.findViewById(R.id.button)
    fun bind(cellsItem: CellsItem) {
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8, cellsItem.topSpacing?.toInt()?:0, 8, 0)
        itemView.layoutParams = lp
        itemView.visibility =  if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
        button.text = cellsItem.message
        button.setOnClickListener { _ -> listener.sendData()}
    }

    interface SendButtonListener{
        fun sendData()
    }
}
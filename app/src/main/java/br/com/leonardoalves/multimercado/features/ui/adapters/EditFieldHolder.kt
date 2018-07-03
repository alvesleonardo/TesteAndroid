package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.viewModels.entities.FillTypeField
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EditFieldHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){

    var editText: TextInputEditText = itemView.findViewById(R.id.editText)
    var textInputLayout: TextInputLayout = itemView.findViewById(R.id.textInputLayout)

    fun bind(cellsItem: CellsItem){
        textInputLayout.hint = cellsItem.message
        itemView.visibility = if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
        val fromString = FillTypeField.fromString(cellsItem.typefield!!)
        println(fromString.toString())
        //
    }
}
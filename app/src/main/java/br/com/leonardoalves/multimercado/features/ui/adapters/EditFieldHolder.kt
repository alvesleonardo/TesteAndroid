package br.com.leonardoalves.multimercado.features.ui.adapters

import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.viewModels.entities.FillTypeField
import br.com.leonardoalves.multimercado.features.viewModels.util.BrPhoneNumberFormatter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.ref.WeakReference


class EditFieldHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){

    var editText: TextInputEditText = itemView.findViewById(R.id.editText)
    var textInputLayout: TextInputLayout = itemView.findViewById(R.id.textInputLayout)
    lateinit var cellItem: CellsItem

    fun bind(cellsItem: CellsItem){
        cellItem = cellsItem
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8, cellItem.topSpacing?.toInt()?:0, 8, 0)
        itemView.layoutParams = lp
        textInputLayout.hint = cellsItem.message
        itemView.visibility = if (cellsItem.hidden == true){View.GONE}else{View.VISIBLE}
        val fromString = if (cellsItem.typefield?.toIntOrNull() != null){
            FillTypeField.fromOrdinal(cellsItem.typefield!!)
        } else {
            FillTypeField.fromString(cellsItem.typefield!!)
        }
        when(fromString){
            FillTypeField.text -> editText.inputType = InputType.TYPE_CLASS_TEXT
            FillTypeField.telnumber -> {
                val addLineNumberFormatter = BrPhoneNumberFormatter(WeakReference<EditText>(editText))
                editText.addTextChangedListener(addLineNumberFormatter)
                editText.inputType = InputType.TYPE_CLASS_PHONE}
            FillTypeField.email -> editText.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            null -> editText.inputType = InputType.TYPE_CLASS_TEXT
        }
        editText.setText("")
    }

    fun validate(): Boolean {
        if (itemView.visibility == View.GONE){
            return true
        }
        if (cellItem.required == true && editText.text.isNullOrEmpty()){
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "Requerido"
            return false
        }
        val fromString = if (cellItem.typefield?.toIntOrNull() != null){
            FillTypeField.fromOrdinal(cellItem.typefield!!)
        } else {
            FillTypeField.fromString(cellItem.typefield!!)
        }
        var valid = when(fromString){
            FillTypeField.text -> true
            FillTypeField.telnumber -> validatePhone(editText.text.toString())
            FillTypeField.email -> Patterns.EMAIL_ADDRESS.matcher(editText.text).matches()
            null -> true
        }
        if (!valid){
            textInputLayout.isErrorEnabled = true
            textInputLayout.error = "Invalido"
        } else{
            textInputLayout.isErrorEnabled = false
        }
        return valid
    }

    private fun validatePhone(string: String):Boolean{
        val regex = Regex("^(\\(11\\) [9][0-9]{4}-[0-9]{4})|(\\(1[2-9]\\) [5-9][0-9]{3}-[0-9]{4})|(\\([2-9][1-9]\\) [5-9][0-9]{3}-[0-9]{4})\$")
        return regex.matches(string)
    }
}
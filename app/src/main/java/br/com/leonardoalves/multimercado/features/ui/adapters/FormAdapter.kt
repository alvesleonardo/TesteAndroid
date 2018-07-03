package br.com.leonardoalves.multimercado.features.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R

class FormAdapter( var listenerCheckbox: CheckboxViewHolder.CheckboxVisibility,
                   var listenerButton: ButtonViewHolder.SendButtonListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: ArrayList<CellsItem> = arrayListOf()

    fun addItem(cellsItem: CellsItem){
        val size = items.size
        items.add(cellsItem)
        notifyItemInserted(size)
    }

    fun clear(){
        items.clear()
        notifyDataSetChanged()
    }

    fun getPositonFromId(id:Int):Int{
        var find = items.find { it.id == id }
        return items.indexOf(find)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            1 -> EditFieldHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_edittext_field, parent, false))
            3 -> ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_imageview_field, parent, false))
            4-> CheckboxViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_checkbox_field, parent, false), listenerCheckbox)
            5 -> ButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_button_field, parent, false), listenerButton)
            else -> TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_textview_field, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)){
            1 -> (holder as EditFieldHolder).bind(items[position])
            3 -> (holder as ImageViewHolder).bind(items[position])
            4-> (holder as CheckboxViewHolder).bind(items[position])
            5 -> (holder as ButtonViewHolder).bind(items[position])
            else -> (holder as TextViewHolder).bind(items[position])
        }
    }

    interface SendDataAndResults{
        fun sendDataAndResults()
    }

}
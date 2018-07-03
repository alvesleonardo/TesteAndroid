package br.com.leonardoalves.multimercado.features.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.InfoItem
import br.com.leonardoalves.multimercado.R
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent.ACTION_VIEW
import android.net.Uri


class InfoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val MORE_INFO: Int = 1
    private val MORE_INFO_DOWNLOAD: Int = 2

    var infoItems:ArrayList<InfoItem> = arrayListOf()
    var donwloadItems:ArrayList<InfoItem> = arrayListOf()

    private fun addInfoItem(infoItem: InfoItem){
        val size = infoItems.size
        infoItems.add(infoItem)
        notifyItemInserted(size)
    }

    private fun addDownloadInfoItem(infoItem: InfoItem){
        val size = donwloadItems.size
        donwloadItems.add(infoItem)
        notifyItemInserted(infoItems.size+size)
    }

    private fun clear(){
        infoItems.clear()
        donwloadItems.clear()
        notifyDataSetChanged()
    }

    fun addItems(infoItem: List<InfoItem?>, downloadInfoItem: List<InfoItem?>){
        clear()
        infoItem.forEach {
            if (it!= null)
                addInfoItem(it)
        }
        downloadInfoItem.forEach {
            if (it!= null)
                addDownloadInfoItem(it)
        }
    }

    override fun getItemCount(): Int {
        return infoItems.size+donwloadItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position<infoItems.size){
            MORE_INFO
        } else{
            MORE_INFO_DOWNLOAD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MORE_INFO) {
            val view =LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_more_info, parent, false)
            ViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_more_info_download, parent, false)
            ViewHolderDownload(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewType = getItemViewType(position)
        if (itemViewType == MORE_INFO){
            holder as ViewHolder
            holder.bind(infoItems[position])
        } else{
            holder as ViewHolderDownload
            holder.bind(donwloadItems[position-infoItems.size])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameField: TextView = itemView.findViewById(R.id.info_name)
        var valueField: TextView = itemView.findViewById(R.id.info_value)
        fun bind(infoItem: InfoItem){
            nameField.text = infoItem.name
            valueField.text = infoItem.data
        }
    }
    class ViewHolderDownload(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameField: TextView = itemView.findViewById(R.id.info_name)
        var valueField: TextView = itemView.findViewById(R.id.info_value)
        fun bind(infoItem: InfoItem){
            nameField.text = infoItem.name
            valueField.text = itemView.context.getString(R.string.download)
            valueField.setOnClickListener {
                if (infoItem.data == null){
                    return@setOnClickListener
                }
                var url = infoItem.data!!
                if (url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://$url"
                val browserIntent = Intent(ACTION_VIEW, Uri.parse(url))
                it.context.startActivity(browserIntent)
            }
        }
    }

}
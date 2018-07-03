package br.com.leonardoalves.multimercado.features.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.presenters.contactFragment.FormPresenter
import br.com.leonardoalves.multimercado.features.presenters.contactFragment.FormView
import br.com.leonardoalves.multimercado.features.ui.adapters.*
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.fragment_form.*
import javax.inject.Inject

class FormFragment: BaseFragment(), FormView, CheckboxViewHolder.CheckboxVisibility, ButtonViewHolder.SendButtonListener {

    @Inject
    lateinit var presenter: FormPresenter

    lateinit var recyclerView: RecyclerView
    lateinit var formAdapter: FormAdapter
    lateinit var loadingView: View
    lateinit var successView: View
    lateinit var resetButton:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)
        val layout = LinearLayoutManager(activity)
        formAdapter = FormAdapter(this, this)
        recyclerView = view.findViewById<RecyclerView>(R.id.contact_form).apply {
            setHasFixedSize(false)
            layoutManager = layout
            adapter = formAdapter
        }
        loadingView = view.findViewById(R.id.loading)
        successView = view.findViewById(R.id.success)
        resetButton = view.findViewById(R.id.button2)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadForm()
        button2.setOnClickListener { loadForm() }
    }

    fun loadForm(){
        formAdapter.clear()
        recyclerView.visibility = View.GONE
        successView.visibility = View.GONE
        loadingView.visibility = View.VISIBLE
        presenter.getForm()
    }

    @SuppressLint("CheckResult")
    override fun subscribeForm(subscribeOn: Flowable<CellsItem>) {
        formAdapter.clear()
        subscribeOn
                .subscribe({
                    formAdapter.addItem(it)
                },{
                    it.printStackTrace()
                },{
                    recyclerView.visibility = View.VISIBLE
                    successView.visibility = View.GONE
                    loadingView.visibility = View.GONE
                })
    }

    override fun setVisible(show: Int?, i: Int) {
        if (show == null){
            return
        }
        var positonFromId = formAdapter.getPositonFromId(show)
        var findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(positonFromId)
        findViewHolderForAdapterPosition?.itemView?.visibility = i
    }

    override fun sendData() {
        var cellsItems = formAdapter.items
        var i=0
        var valid = true
        while (i< cellsItems.size){
            var holder = recyclerView.findViewHolderForAdapterPosition(i)
            valid = valid.and(when (formAdapter.getItemViewType(i)) {
                1 -> (holder as EditFieldHolder).validate()
                4 -> (holder as CheckboxViewHolder).validate()
                else -> true
            })
            i++
        }
        if (!valid){
            println("invalido")
        }else{
            recyclerView.visibility = View.GONE
            successView.visibility = View.VISIBLE
            loadingView.visibility = View.GONE
        }
    }
}
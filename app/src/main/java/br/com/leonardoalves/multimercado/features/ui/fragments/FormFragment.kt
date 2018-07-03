package br.com.leonardoalves.multimercado.features.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardoalves.dataInfrastructure.data.entities.CellsItem
import br.com.leonardoalves.multimercado.R
import br.com.leonardoalves.multimercado.features.presenters.contactFragment.FormPresenter
import br.com.leonardoalves.multimercado.features.presenters.contactFragment.FormView
import br.com.leonardoalves.multimercado.features.ui.adapters.CheckboxViewHolder
import br.com.leonardoalves.multimercado.features.ui.adapters.FormAdapter
import io.reactivex.Flowable
import javax.inject.Inject

class FormFragment: BaseFragment(), FormView, CheckboxViewHolder.CheckboxVisibility {

    @Inject
    lateinit var presenter: FormPresenter

    lateinit var recyclerView: RecyclerView
    lateinit var formAdapter: FormAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)
        val layout = LinearLayoutManager(activity)
        formAdapter = FormAdapter(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.contact_form).apply {
            setHasFixedSize(true)
            layoutManager = layout
            adapter = formAdapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getForm()
    }

    @SuppressLint("CheckResult")
    override fun subscribeForm(subscribeOn: Flowable<CellsItem>) {
        formAdapter.clear()
        subscribeOn
                .subscribe({
                    println(it.message)
                    formAdapter.addItem(it)
                },{
                    it.printStackTrace()
                },{

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
}
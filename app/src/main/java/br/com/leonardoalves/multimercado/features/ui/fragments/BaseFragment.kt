package br.com.leonardoalves.multimercado.features.ui.fragments

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment:Fragment()  {

    override fun onAttach(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(*Activity*).
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here for versions before M as onAttach(*Context*) did not yet exist
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(activity)
    }
}
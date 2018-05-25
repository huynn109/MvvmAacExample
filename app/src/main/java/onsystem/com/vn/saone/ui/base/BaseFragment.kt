package onsystem.com.vn.saone.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

/**
 * Base fragment will extend all the fragments
 */
abstract class BaseFragment<VM : ViewModel, DB: ViewDataBinding>: Fragment() {

    // view model factory instance
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // data binding instance
    lateinit var dataBinding: DB

    // view model instance
    lateinit var viewModel: VM

    /**
     * get view model
     */
    abstract fun getViewModel(): Class<VM>

    /**
     * get fragment layout
     */
    @LayoutRes
    abstract fun getLayoutRes(): Int

    /**
     * override onCreate method of fragment that will inject this fragment and set its view model
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    /**
     * override onCreateView method that will set the data binding view
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return dataBinding.root
    }
}
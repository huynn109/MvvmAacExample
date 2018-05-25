package onsystem.com.vn.saone.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import onsystem.com.vn.saone.R
import onsystem.com.vn.saone.ui.base.BaseFragment

class MainActivityFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    companion object {
        private val TAG = MainActivityFragment::class.java.simpleName
    }

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.deleteUserStockList()
        viewModel.getUserStockList()
                .observe(this, Observer {
                    it?.forEach {
                        println("${it.symbol}, ${it.company}")
                    }
                })
    }
}
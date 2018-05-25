package onsystem.com.vn.saone.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import onsystem.com.vn.saone.di.VMFactory
import onsystem.com.vn.saone.di.scope.ViewModelKey
import onsystem.com.vn.saone.ui.main.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(vmFactory: VMFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}
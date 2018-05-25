package onsystem.com.vn.saone.di.module

import dagger.Module
import onsystem.com.vn.saone.ui.main.MainActivityFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainActivityFragment
}
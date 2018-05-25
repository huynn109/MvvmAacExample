package onsystem.com.vn.saone.di.module

import dagger.Module
import onsystem.com.vn.saone.ui.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [(FragmentModule::class)])
    abstract fun mainActivity(): MainActivity
}
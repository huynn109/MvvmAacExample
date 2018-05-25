package onsystem.com.vn.saone.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import onsystem.com.vn.saone.SAOneApplication
import onsystem.com.vn.saone.di.module.ActivityModule
import onsystem.com.vn.saone.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::java), (AppModule::class), (ActivityModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: SAOneApplication)
}
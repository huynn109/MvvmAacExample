package onsystem.com.vn.saone.di.module

import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import android.app.Application
import android.content.Context


@Module(includes = [(ViewModelModule::class)])
class AppModule{
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

}
package com.basik.balda.di

import androidx.databinding.ViewDataBinding
import com.basik.balda.view.base.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun inject(baseFragment: BaseFragment<ViewDataBinding>)

}
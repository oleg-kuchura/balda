package com.basik.balda.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basik.balda.view.base.BaseViewModel
import com.basik.balda.view.fragments.game_options.GameOptionsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel::class)
    internal abstract fun baseViewModel(viewModel: BaseViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GameOptionsViewModel::class)
    internal abstract fun gameOptionsViewModel(viewModel: GameOptionsViewModel): ViewModel

}
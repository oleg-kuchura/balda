package com.basik.balda.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.basik.balda.databinding.FragmentMainMenuBinding
import com.basik.balda.view.base.BaseFragment
import com.basik.balda.view.base.BaseViewModel

class MainMenuFragment : BaseFragment<FragmentMainMenuBinding>() {

    private val viewModel by viewModels<BaseViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
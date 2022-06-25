package com.basik.balda.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.basik.balda.databinding.FragmentMainMenuBinding
import com.basik.balda.view.base.BaseFragment
import com.basik.balda.view.base.BaseViewModel
import com.basik.balda.view.utils.onClick

class MainMenuFragment : BaseFragment<FragmentMainMenuBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.startGameWithFriends.onClick(::navigateToGameOptions)
    }

    private fun navigateToGameOptions() {
        findNavController().navigate(MainMenuFragmentDirections.toGameOptions())
    }
}
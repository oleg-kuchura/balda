package com.basik.balda.view.fragments.game_options

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.basik.balda.databinding.FragmentGameOptionsBinding
import com.basik.balda.view.base.BaseFragment

class GameOptionsFragment : BaseFragment<FragmentGameOptionsBinding>() {

    private val viewModel by viewModels<GameOptionsViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initBinding()
    }

    private fun initRecycler() {
        binding.recyclerPlayers.adapter = PlayersAdapter(viewModel::removePlayer)
    }

    private fun initBinding() {
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}
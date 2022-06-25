package com.basik.balda.view.binding_adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.basik.balda.model.GamePlayer
import com.basik.balda.view.fragments.game_options.PlayersAdapter

@BindingAdapter("app:playerList")
fun RecyclerView.playerList(value: List<GamePlayer>?) {
    (adapter as? PlayersAdapter)?.players = value ?: emptyList()
}
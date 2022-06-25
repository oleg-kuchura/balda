package com.basik.balda.view.fragments.game_options

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.basik.balda.databinding.ItemPlayerBinding
import com.basik.balda.model.GamePlayer
import timber.log.Timber

class PlayersAdapter(
    private val removePlayerListener: (Int) -> Unit
): RecyclerView.Adapter<PlayersAdapter.PlayersVH>() {

    var players = listOf<GamePlayer>()
        set(value) {
            val diffResult = DiffUtil.calculateDiff(PlayersDiffUtilCallback(field, value))
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PlayersVH(
            ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PlayersVH, position: Int) {
        holder.bindPlayer(players[position])
    }

    override fun getItemCount(): Int = players.size

    inner class PlayersVH(
        private val binding: ItemPlayerBinding
    ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.chipPlayerName.setOnCloseIconClickListener {
                adapterPosition.takeIf { it != NO_POSITION }?.let(removePlayerListener)
            }
        }

        fun bindPlayer(player: GamePlayer) {
            binding.player = player
            binding.executePendingBindings()
        }
    }

    class PlayersDiffUtilCallback(
        private val oldList: List<GamePlayer>,
        private val newList: List<GamePlayer>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int =  oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem.nickname == newItem.nickname
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }
}
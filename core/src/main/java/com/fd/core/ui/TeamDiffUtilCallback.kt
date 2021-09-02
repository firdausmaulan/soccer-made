package com.fd.core.ui

import androidx.recyclerview.widget.DiffUtil
import com.fd.core.domain.model.Team

class TeamDiffUtilCallback(
    private val oldList: List<Team>,
    private val newList: List<Team>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].idTeam == newList[newItemPosition].idTeam
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
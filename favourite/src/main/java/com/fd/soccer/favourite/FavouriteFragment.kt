package com.fd.soccer.favourite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fd.core.ui.TeamAdapter
import com.fd.core.utils.hide
import com.fd.core.utils.show
import com.fd.soccer.favourite.databinding.FragmentFavouriteBinding
import com.fd.soccer.ui.detail.TeamDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteFragment : Fragment() {

    private val favoriteViewModel: FavouriteViewModel by viewModel()

    private lateinit var binding: FragmentFavouriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val teamAdapter = TeamAdapter()
            teamAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, TeamDetailActivity::class.java)
                intent.putExtra(TeamDetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteTeams.observe(viewLifecycleOwner, { teams ->
                teamAdapter.setData(teams)
                if (teams.isEmpty()) binding.viewEmpty.root.show()
                else binding.viewEmpty.root.hide()
            })

            with(binding.rvTeams) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }
}

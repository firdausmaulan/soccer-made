package com.fd.soccer.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fd.core.data.Resource
import com.fd.core.ui.TeamAdapter
import com.fd.core.utils.hide
import com.fd.core.utils.show
import com.fd.soccer.R
import com.fd.soccer.databinding.FragmentHomeBinding
import com.fd.soccer.ui.detail.TeamDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment constructor(private val idLeague: String) : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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

            homeViewModel.getTeams(idLeague).observe(viewLifecycleOwner, { teams ->
                if (teams != null) {
                    when (teams) {
                        is Resource.Loading -> binding.progressBar.show()
                        is Resource.Success -> {
                            binding.progressBar.hide()
                            teamAdapter.setData(teams.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.hide()
                            binding.viewError.root.show()
                            binding.viewError.tvError.text =
                                teams.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvTeams) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamAdapter
            }
        }
    }
}

package com.fd.soccer.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.fd.core.domain.model.Team
import com.fd.core.utils.Constant
import com.fd.core.utils.load
import com.fd.soccer.R
import com.fd.soccer.databinding.ActivityTeamDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val viewModel: TeamDetailViewModel by viewModel()
    private lateinit var binding: ActivityTeamDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val teamDetail = intent.getParcelableExtra<Team>(EXTRA_DATA)
        showTeamDetail(teamDetail)
    }

    private fun showTeamDetail(team: Team?) {
        team?.let {
            supportActionBar?.title = team.strTeam
            binding.content.tvDetailDescription.text = team.strDescription
            binding.ivDetailImage.load(team.strTeamJersey)

            var statusFavorite = team.intLoved
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite =
                    if (statusFavorite == Constant.LOVED)
                        Constant.UNLOVED
                    else
                        Constant.LOVED
                viewModel.setFavouriteTeam(team, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(loved: Int?) {
        if (loved == Constant.LOVED) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favourite_red
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favourite_black
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

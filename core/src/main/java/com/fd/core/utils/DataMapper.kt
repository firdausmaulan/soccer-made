package com.fd.core.utils

import com.fd.core.data.source.local.entity.TeamEntity
import com.fd.core.data.source.remote.response.TeamResponse
import com.fd.core.domain.model.Team

object DataMapper {
    fun mapResponsesToEntities(input: List<TeamResponse>): List<TeamEntity> {
        val teamList = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                idTeam = it.idTeam ?: "",
                idLeague = it.idLeague,
                intLoved = Constant.UNLOVED,
                strTeam = it.strTeam,
                strDescription = it.strDescriptionEN,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strStadiumDescription = it.strStadiumDescription,
                strTeamBadge = it.strTeamBadge,
                strTeamJersey = it.strTeamJersey,
                strTeamLogo = it.strTeamLogo,
                strTeamFanart = it.strTeamFanart1,
                strTeamBanner = it.strTeamBanner
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Team> =
        input.map {
            Team(
                idTeam = it.idTeam,
                idLeague = it.idLeague ?: "",
                intLoved = it.intLoved ?: 0,
                strTeam = it.strTeam ?: "",
                strDescription = it.strDescription ?: "",
                strStadium = it.strStadium ?: "",
                strStadiumThumb = it.strStadiumThumb + Constant.PREVIEW_IMG,
                strStadiumDescription = it.strStadiumDescription ?: "",
                strTeamBadge = it.strTeamBadge + Constant.PREVIEW_IMG,
                strTeamJersey = it.strTeamJersey + Constant.PREVIEW_IMG,
                strTeamLogo = it.strTeamLogo + Constant.PREVIEW_IMG,
                strTeamFanart = it.strTeamFanart + Constant.PREVIEW_IMG,
                strTeamBanner = it.strTeamBanner + Constant.PREVIEW_IMG
            )
        }

    fun mapDomainToEntity(input: Team) = TeamEntity(
        idTeam = input.idTeam,
        idLeague = input.idLeague,
        intLoved = input.intLoved,
        strTeam = input.strTeam,
        strDescription = input.strDescription,
        strStadium = input.strStadium,
        strStadiumThumb = input.strStadiumThumb.replace(Constant.PREVIEW_IMG, ""),
        strStadiumDescription = input.strStadiumDescription,
        strTeamBadge = input.strTeamBadge.replace(Constant.PREVIEW_IMG, ""),
        strTeamJersey = input.strTeamJersey.replace(Constant.PREVIEW_IMG, ""),
        strTeamLogo = input.strTeamLogo.replace(Constant.PREVIEW_IMG, ""),
        strTeamFanart = input.strTeamFanart.replace(Constant.PREVIEW_IMG, ""),
        strTeamBanner = input.strTeamBanner.replace(Constant.PREVIEW_IMG, "")
    )
}
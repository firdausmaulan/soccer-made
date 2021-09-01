package com.fd.core.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    var idTeam: String,
    @SerializedName("idLeague")
    var idLeague: String,
    @SerializedName("intLoved")
    var intLoved: Int,
    @SerializedName("strTeam")
    var strTeam: String,
    @SerializedName("strDescription")
    var strDescription: String,
    @SerializedName("strStadium")
    var strStadium: String,
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String,
    @SerializedName("strStadiumDescription")
    var strStadiumDescription: String,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String,
    @SerializedName("strTeamJersey")
    var strTeamJersey: String,
    @SerializedName("strTeamLogo")
    var strTeamLogo: String,
    @SerializedName("strTeamFanart")
    var strTeamFanart: String,
    @SerializedName("strTeamBanner")
    var strTeamBanner: String,
) : Parcelable
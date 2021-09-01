package com.fd.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,
    @SerializedName("idLeague")
    var idLeague: String?,
    @ColumnInfo(name = "intLoved")
    var intLoved: Int?,
    @ColumnInfo(name = "strTeam")
    var strTeam: String?,
    @ColumnInfo(name = "strDescription")
    var strDescription: String?,
    @ColumnInfo(name = "strStadium")
    var strStadium: String?,
    @ColumnInfo(name = "strStadiumThumb")
    var strStadiumThumb: String?,
    @ColumnInfo(name = "strStadiumDescription")
    var strStadiumDescription: String?,
    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String?,
    @ColumnInfo(name = "strTeamJersey")
    var strTeamJersey: String?,
    @ColumnInfo(name = "strTeamLogo")
    var strTeamLogo: String?,
    @ColumnInfo(name = "strTeamFanart")
    var strTeamFanart: String?,
    @ColumnInfo(name = "strTeamBanner")
    var strTeamBanner: String?,
)
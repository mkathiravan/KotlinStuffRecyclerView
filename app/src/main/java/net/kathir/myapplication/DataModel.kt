package net.kathir.myapplication

import android.support.annotation.IntegerRes
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel(

    @Expose
    @SerializedName("albumId")
    val albumId : Integer,

    @Expose
    @SerializedName("id")
    val id : Integer,

    @Expose
    @SerializedName("title")
    val title : String,

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailUrl : String







)

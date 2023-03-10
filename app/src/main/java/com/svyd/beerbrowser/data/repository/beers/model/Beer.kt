package com.svyd.beerbrowser.data.repository.beers.model

import com.google.gson.annotations.SerializedName

data class Beer(val name: String, val description: String, @SerializedName("image_url") val image: String)

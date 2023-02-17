package com.example.aptoide.model

import com.example.aptoide.model.ListApps
import com.google.gson.annotations.SerializedName


data class Responses (

  @SerializedName("listApps" ) var listApps : ListApps? = ListApps()

)
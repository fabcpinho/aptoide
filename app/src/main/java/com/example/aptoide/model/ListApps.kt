package com.example.aptoide.model

import com.google.gson.annotations.SerializedName

data class ListApps (

  @SerializedName("info"     ) var info     : Info?     = Info(),
  @SerializedName("datasets" ) var datasets : Datasets? = Datasets()

)
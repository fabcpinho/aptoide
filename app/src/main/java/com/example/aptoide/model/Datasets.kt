package com.example.aptoide.model

import com.example.aptoide.model.All
import com.google.gson.annotations.SerializedName


data class Datasets (

  @SerializedName("all" ) var all : All? = All()

)
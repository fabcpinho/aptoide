package com.example.aptoide.model

import com.google.gson.annotations.SerializedName


data class AppsDataset(

    @SerializedName("status") var status: String? = null,
    @SerializedName("responses") var responses: Responses? = Responses()

)
package com.example.anderson.repository.model.entityrequest

import com.google.gson.annotations.SerializedName

/**
 * Created by Anderson on 06/09/2020.
 */
class OwnerResult(@SerializedName("login")
                    val name: String  = "",
                  @SerializedName("avatar_url")
                    val urlAvatar: String  = ""){
}
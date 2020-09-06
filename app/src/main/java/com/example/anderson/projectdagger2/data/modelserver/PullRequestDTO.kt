package com.example.anderson.repository.model.entityrequest

import com.google.gson.annotations.SerializedName

/**
 * Created by Anderson on 06/09/2020.
 */
class PullRequestDTO (val title: String,
                      val body: String,
                      @SerializedName("created_at")
                          val dataCreatePullRequest: String,
                      @SerializedName("html_url")
                          val urlPullRequest: String,
                      @SerializedName("user")
                          val user: UserResult  ) {

}
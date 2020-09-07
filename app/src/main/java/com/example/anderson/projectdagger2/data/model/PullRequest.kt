package com.example.anderson.repository.model.entity

/**
 * Created by Anderson on 06/09/2020.
 */
data class PullRequest ( val title: String,
                    val body: String,
                    val dataCreatePullRequest: String,
                    val urlPullRequest: String,
                    val user: User )  {
}
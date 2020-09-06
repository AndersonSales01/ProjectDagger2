package com.example.anderson.repository.model.entityrequest

import com.google.gson.annotations.SerializedName

/**
 * Created by Anderson on 06/09/2020.
 */
class ResponseDTO(@SerializedName("items")
                        val repositoryList: List<RepositoryResult>) {


}
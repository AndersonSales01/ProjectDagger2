package com.example.anderson.projectdagger2.data.repository

import android.content.Context
import android.util.Log
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.data.networking.NetworkConfig
import com.example.anderson.projectdagger2.data.networking.endpoint.GitHubEndPoint
import com.example.anderson.repository.model.entityrequest.ResponseDTO
import javax.inject.Inject

class RepoGitHubImpl @Inject constructor(val context: Context) : IRepoGitHub {

    override suspend fun loadRepository(page: Int) =
        NetworkConfig.provideApi(GitHubEndPoint::class.java,context).listRepository(page).await()



//    override suspend fun loadRepository(page: Int): List<Repository>{
//
//        val listRepositorys = ArrayList<Repository>()
//
//        var response = NetworkConfig.provideApi(GitHubEndPoint::class.java,context).listRepository(page).await()
//
//
//        response.let {
//
//            if (response.repositoryList.isNotEmpty()) {
//
//                for (repo in response!!.repositoryList) {
//
//
//                    if (repo.owner != null && repo.description != null) {
//
//                        val repository = Repository(repo.nameRepository, repo.fullName, repo.description,
//                            repo.numberForks, repo.numberStarts, Author(repo.owner.name, repo.owner.urlAvatar))
//
//                        listRepositorys.add(repository)
//
//                    }
//                }
//
//            }
//        }
//
//
//        return listRepositorys
//    }




}
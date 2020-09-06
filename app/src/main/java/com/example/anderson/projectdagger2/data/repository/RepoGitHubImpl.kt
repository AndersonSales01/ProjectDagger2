package com.example.anderson.projectdagger2.data.repository

import com.example.anderson.projectdagger2.data.model.Repository

class RepoGitHubImpl: IRepoGitHub {

    override suspend fun loadRepository(page: Int): List<Repository> {

        val listRepositorys = ArrayList<Repository>()

//        var response = RepositoryApi.getInstance().create(RepositoryEndPoint::class.java).listRepository(page).await()
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


        return listRepositorys
    }
}
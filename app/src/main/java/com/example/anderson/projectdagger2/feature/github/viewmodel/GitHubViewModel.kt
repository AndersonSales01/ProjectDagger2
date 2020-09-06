package com.example.anderson.projectdagger2.feature.github.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anderson.projectdagger2.data.model.Author
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.data.repository.IRepoGitHub
import com.example.anderson.repository.model.entityrequest.ResponseDTO
import com.github.kittinunf.result.coroutines.SuspendableResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GitHubViewModel @Inject constructor(val repository: IRepoGitHub, val context: Context) : ViewModel() {

    private var listRepository = mutableListOf<Repository>()

    private var liveDataListRepository = MutableLiveData<List<Repository>>()

    private var showProgress = MutableLiveData<Boolean>()

    private var page = 1


    fun callrequestRepository() {

        if (listRepository.size <= 0) {

            requestRepository()
        }

    }

    private fun requestRepository() {
        showProgress.postValue(true)
        val listRepositorys = ArrayList<Repository>()
        showProgress.value = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {


                SuspendableResult.of<ResponseDTO, Exception> {

                    repository.loadRepository(page)
                }.fold(success = { response ->
                    if (response.repositoryList.isNotEmpty()) {
                        for (repo in response.repositoryList) {

                            if (repo.owner != null && repo.description != null) {

                                val repository = Repository(
                                    repo.nameRepository,
                                    repo.fullName,
                                    repo.description,
                                    repo.numberForks,
                                    repo.numberStarts,
                                    Author(repo.owner.name, repo.owner.urlAvatar)
                                )

                                listRepositorys.add(repository)

                            }
                        }
                        liveDataListRepository.postValue(listRepositorys)
                    }

                    page++
                }, failure = { error ->
                    Log.d("Error", "${error.toString()}")
                })

                showProgress.postValue(false)
            }
        }
    }

    fun getMoreItems(currentItems: Int, scrollOutItems: Int, totalItems: Int) {

        if (currentItems + scrollOutItems >= totalItems) {
            requestRepository()
        }
    }

    fun getListRespository(): LiveData<List<Repository>> = liveDataListRepository
    fun showProgress(): LiveData<Boolean> = showProgress

}
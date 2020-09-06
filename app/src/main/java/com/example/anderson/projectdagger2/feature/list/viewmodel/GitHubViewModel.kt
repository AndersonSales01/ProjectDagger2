package com.example.anderson.projectdagger2.feature.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.data.repository.IRepoGitHub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitHubViewModel(val repository: IRepoGitHub) : ViewModel() {

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

        showProgress.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO) {


//                val response = SuspendableResult.of<List<Repository>, Exception> {
//
//                    repository.loadRepository(page)
//                }
//                val onSuccess: suspend (List<Repository>) -> Unit = { list ->
//                    liveDataListRepository.postValue(list)
//                    page++
//                }
//                val onFailure: suspend (Exception) -> Unit = { error ->
//                    Log.d("Error Request", error.toString())
//                }
//
//
//                response.fold(onSuccess, onFailure)
//
//
//                showProgress.postValue(false)
            }
        }
    }

}
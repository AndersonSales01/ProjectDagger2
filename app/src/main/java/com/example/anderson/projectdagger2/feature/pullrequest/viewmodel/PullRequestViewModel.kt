package com.example.anderson.projectdagger2.feature.pullrequest.viewmodel


import android.util.Log
import androidx.lifecycle.*
import com.example.anderson.projectdagger2.data.repository.IRepoPullRquest
import com.example.anderson.repository.model.entity.PullRequest
import com.example.anderson.repository.model.entity.User
import com.example.anderson.repository.model.entityrequest.PullRequestDTO
import com.github.kittinunf.result.coroutines.SuspendableResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject


/**
 * Created by Anderson on 06/09/2020.
 */
class PullRequestViewModel@Inject constructor(val repository: IRepoPullRquest) : ViewModel(), LifecycleObserver {

    private var listPullRequest = mutableListOf<PullRequest>()

    private var liveDataListPullRequestRepository = MutableLiveData<List<PullRequest>>()
    private var showProgress = MutableLiveData<Boolean>()

    private var result  = MutableLiveData<Int>()


    fun callRequestPullResquest(nameOwner: String, nameRepository: String) {

        if (nameOwner != null && nameOwner != "" && nameRepository != null && nameRepository != "") {

            requestPullRequest(nameOwner, nameRepository)

        }

    }

    private fun requestPullRequest(nameOwner: String, nameRepository: String) {

        showProgress.postValue(true)

        viewModelScope.launch {

            withContext(Dispatchers.IO) {

                SuspendableResult.of<List<PullRequestDTO>, Exception> {

                    repository.loadPullRequest(nameOwner, nameRepository)

                }.fold(
                    success = { response ->
                        if (response.isNotEmpty()) {
                            for (pullRequest in response) {

                                val pullRequestObj = PullRequest(
                                    pullRequest.title,
                                    pullRequest.body,
                                    pullRequest.dataCreatePullRequest,
                                    pullRequest.urlPullRequest,
                                    User(pullRequest.user.name, pullRequest.user.avatarURL)
                                )

                                listPullRequest.add(pullRequestObj)

                            }

                            liveDataListPullRequestRepository.postValue(listPullRequest)
                        }
                        showProgress.postValue(false)

                    },
                    failure = { error ->

                        Log.d("Error Request", error.toString())
                        showProgress.postValue(false)

                    }
                )
            }
        }
    }


    fun getListPullRequests(): LiveData<List<PullRequest>> = liveDataListPullRequestRepository
    fun showProgress(): LiveData<Boolean> = showProgress

}
package com.example.anderson.projectdagger2.feature.pullrequest.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.constants.Constants
import com.example.anderson.projectdagger2.feature.BaseActivity
import com.example.anderson.projectdagger2.feature.pullrequest.ui.adapter.PullRequestAdapter
import com.example.anderson.projectdagger2.feature.pullrequest.viewmodel.PullRequestViewModel

import kotlinx.android.synthetic.main.activity_pull_request.*
import javax.inject.Inject

class PullRequestActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: PullRequestViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[PullRequestViewModel::class.java]
    }
    private lateinit var pullRequestAdapter: PullRequestAdapter
    private  lateinit var nameRepository: String
    private  lateinit var nameOwner: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_request)

        uiComponent.inject(this)

        initialize()
    }

    override fun initialize(){

        initViews()

        observables()

        viewModel.callRequestPullResquest(nameOwner, nameRepository)

    }



    override fun initViews() {

        pullRequestAdapter = PullRequestAdapter(this)

        recyclerView_pull_request.layoutManager = LinearLayoutManager(this)
        recyclerView_pull_request.adapter = pullRequestAdapter

        val intent = intent
        nameRepository = intent.getStringExtra(Constants.NAME_REPOSITORY)
        nameOwner = intent.getStringExtra(Constants.NAME_OWNER)

        val actionbar = supportActionBar

        if (nameRepository != "") {

            if (actionbar != null) {
                actionbar.title = nameRepository
            }
        }

    }

    override fun observables() {

        viewModel.getListPullRequests().observe(this, Observer { listPullRquests ->
            pullRequestAdapter.loadPullRequest(listPullRquests!!)

        })

        viewModel.showProgress().observe(this, Observer { isShow ->
            if (isShow!!) {
                progress_pull_request.visibility = View.GONE

            }
        })
    }
}
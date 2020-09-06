package com.example.anderson.projectdagger2.feature.github.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anderson.projectdagger2.feature.BaseActivity
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.constants.Constants
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.feature.pullrequest.ui.IGitHubActivity
import com.example.anderson.projectdagger2.feature.pullrequest.ui.activity.PullRequestActivity
import com.example.anderson.projectdagger2.feature.di.UiComponent
import com.example.anderson.projectdagger2.feature.github.ui.adapter.GitHubAdapter
import com.example.anderson.projectdagger2.feature.github.viewmodel.GitHubViewModel
import kotlinx.android.synthetic.main.activity_git_hub_main.*
import javax.inject.Inject

class GitHubActivity : BaseActivity(),
    IGitHubActivity {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: GitHubViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[GitHubViewModel::class.java]
    }
    lateinit var uiComponentTeste: UiComponent
    private lateinit var gitHubAdapter: GitHubAdapter
    private var isScrolling: Boolean = true
    private lateinit var manager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_hub_main)

        uiComponent.inject(this)

        initialize()
    }

    override fun initialize() {

        initViews()

        observables()

        viewModel.callrequestRepository()
    }

    override fun initViews() {
        gitHubAdapter =
            GitHubAdapter(this,this)

        manager = LinearLayoutManager(this)

        list_repository.layoutManager = manager
        list_repository.adapter = gitHubAdapter

        scrollInfinite()
    }

    override fun observables() {

        viewModel.getListRespository().observe(this, Observer { listRespository ->
            gitHubAdapter.loadRepository(listRespository!!)
            isScrolling = true

        })

        viewModel.showProgress().observe(this, Observer { isShow ->

            if (isShow!!) {
                progress_repository.visibility = View.VISIBLE

            } else {
                progress_repository.visibility = View.GONE
            }
        })

    }

    fun scrollInfinite() {

        list_repository.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                viewModel.getMoreItems(manager.childCount, manager.findFirstVisibleItemPosition(), manager.itemCount)

            }

        })
    }

    override fun toGoPullRequestScrenn(repository: Repository) {
        val intent = Intent(this, PullRequestActivity::class.java)
        intent.putExtra(Constants.NAME_OWNER, repository.author.name)
        intent.putExtra(Constants.NAME_REPOSITORY, repository.name)
        startActivity(intent)
    }
}
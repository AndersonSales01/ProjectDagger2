package com.example.anderson.projectdagger2.feature.list.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anderson.projectdagger2.feature.BaseActivity
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.feature.list.viewmodel.GitHubViewModel
import kotlinx.android.synthetic.main.activity_git_hub_main.*

class GitHubActivity : BaseActivity() {

    private lateinit var viewmodel: GitHubViewModel
    private lateinit var gitHubAdapter: GitHubAdapter
    private var isScrolling: Boolean = true
    private lateinit var manager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_hub_main)

        initialize()
    }

    override fun initialize() {

        initViews()

        observables()

        viewmodel.callrequestRepository()
    }

    override fun initViews() {
        gitHubAdapter = GitHubAdapter(this)

        manager = LinearLayoutManager(this)

        list_repository.layoutManager = manager
        list_repository.adapter = gitHubAdapter

        scrollInfinite()
    }

    override fun observables() {
        TODO("Not yet implemented")
    }

    fun scrollInfinite() {

        list_repository.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                //repositoryViewModel.getMoreItems(manager.childCount, manager.findFirstVisibleItemPosition(), manager.itemCount)

            }

        })
    }
}
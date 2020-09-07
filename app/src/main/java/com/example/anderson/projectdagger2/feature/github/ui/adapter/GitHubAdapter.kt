package com.example.anderson.projectdagger2.feature.github.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.feature.github.ui.IGitHubActivity
import com.example.anderson.projectdagger2.feature.github.ui.viewholder.GitHubViewHolder

class GitHubAdapter(val context: Context,  val iGitHubActivity: IGitHubActivity) : RecyclerView.Adapter<GitHubViewHolder>() {

    private var listRepository: List<Repository> = mutableListOf()

    fun loadRepository(listRepository: List<Repository>) {
        this.listRepository = listRepository
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holderViewHolder: GitHubViewHolder, position: Int) {
        val repository = listRepository[position]

        holderViewHolder?.bindView(repository)
    }

    override fun getItemCount(): Int {
        return listRepository.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_repository, parent, false)
        return GitHubViewHolder(view, context,iGitHubActivity)
    }
}
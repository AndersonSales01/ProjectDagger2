package com.example.anderson.projectdagger2.feature.pullrequest.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.feature.pullrequest.ui.viewholder.ViewHolderPullRequest
import com.example.anderson.repository.model.entity.PullRequest

/**
 * Created by Anderson on 06/09/2020.
 */
class PullRequestAdapter( val context: Context) : RecyclerView.Adapter<ViewHolderPullRequest>() {

    private var listPullRequest: List<PullRequest> = mutableListOf()

    fun loadPullRequest(listPullRequest: List<PullRequest>) {
        this.listPullRequest = listPullRequest
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolderPullRequest, position: Int) {
        val pullRequest = listPullRequest[position]

        holder?.bindView(pullRequest)
    }

    override fun getItemCount(): Int {
        return listPullRequest.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPullRequest {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_pull_request, parent, false)
        return ViewHolderPullRequest(view,context)
    }
}
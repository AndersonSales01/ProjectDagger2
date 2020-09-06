package com.example.anderson.projectdagger2.feature.github.ui.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.projectdagger2.feature.pullrequest.ui.IGitHubActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_repository.view.*


class GitHubViewHolder(itemView: View, private val context: Context, private val iGitHubActivity: IGitHubActivity) : RecyclerView.ViewHolder(itemView) {


    fun bindView(repository: Repository) {

        val txtRepositoryName = itemView.repo_name
        val txtLogin = itemView.login
        val txtNumberStarts = itemView.number_stars
        val txtNumberForks = itemView.number_forks
        val txtDescription = itemView.description


        txtRepositoryName.text = repository.name
        txtLogin.text = repository.author.name
        txtNumberStarts.text = repository.numberStarts.toString()
        txtNumberForks.text = repository.numberForks.toString()
        txtDescription.text = repository.description

        getImagem(repository.author.urlAvatar)

        itemView.setOnClickListener {
            iGitHubActivity.toGoPullRequestScrenn(repository)
        }
    }

    private fun getImagem(urlImg: String) {
        Picasso
            .with(context)
            .load(urlImg)
            .into(itemView.ic_user)
    }


}
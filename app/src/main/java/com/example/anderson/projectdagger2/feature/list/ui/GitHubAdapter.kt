package com.example.anderson.projectdagger2.feature.list.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anderson.projectdagger2.R
import com.example.anderson.projectdagger2.data.model.Repository

class GitHubAdapter(val context: Context) : RecyclerView.Adapter<ViewHolderRepository>() {

    private var listRepository: List<Repository> = mutableListOf()

    fun loadRepository(listRepository: List<Repository>) {
        this.listRepository = listRepository
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolderRepository, position: Int) {
        val repository = listRepository[position]

        holder?.bindView(repository)
    }

    override fun getItemCount(): Int {
        return listRepository.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRepository {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_repository, parent, false)
        return ViewHolderRepository(view,context)
    }
}
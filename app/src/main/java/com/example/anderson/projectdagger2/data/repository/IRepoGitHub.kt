package com.example.anderson.projectdagger2.data.repository

import com.example.anderson.projectdagger2.data.model.Repository

interface IRepoGitHub {

    suspend fun loadRepository(page:Int) : List<Repository>
}
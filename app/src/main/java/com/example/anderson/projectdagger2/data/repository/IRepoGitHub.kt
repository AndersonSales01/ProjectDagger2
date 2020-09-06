package com.example.anderson.projectdagger2.data.repository

import com.example.anderson.projectdagger2.data.model.Repository
import com.example.anderson.repository.model.entityrequest.ResponseDTO

interface IRepoGitHub {
    suspend fun loadRepository(page:Int) : ResponseDTO
}
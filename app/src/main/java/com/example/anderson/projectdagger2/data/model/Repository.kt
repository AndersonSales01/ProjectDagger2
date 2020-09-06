package com.example.anderson.projectdagger2.data.model

data class Repository(val name: String = "",
                 val fullName: String = "",
                 val description: String = "",
                 val numberForks: Int = 0,
                 val numberStarts: Int = 0,
                 val author: Author
)
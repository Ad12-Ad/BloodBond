package com.example.bloodbond.ui.theme

import com.example.bloodbond.R
import com.example.bloodbond.data.Post1

class Datasource {
    fun postList(): List<Post1> {
        return listOf<Post1>(
            Post1("Tabitha Potter","mis_potter",14, R.string.post_1 ,R.drawable.post1_profile),
            Post1("Maximmilian","maxjacobson",3, R.string.post_2, R.drawable.post2_profile),
            Post1("Maximmilian","maxjacobson",3, R.string.post_1, R.drawable.post1_profile),
            Post1("Maximmilian","maxjacobson",3, R.string.post_2, R.drawable.post2_profile),
        )
    }
}
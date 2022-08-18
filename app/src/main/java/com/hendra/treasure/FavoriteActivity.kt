package com.hendra.treasure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = "My Treasure"

        recyclerView = findViewById(R.id.rv_members)
        recyclerView.setHasFixedSize(true)

        list.addAll(MembersData.listData)
        showRV()
    }

    private fun showRV() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = CardViewMemberAdapter(list)
        recyclerView.adapter = listHeroAdapter
    }
}
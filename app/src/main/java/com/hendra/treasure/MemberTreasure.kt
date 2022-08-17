package com.hendra.treasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MemberTreasure : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_treasure)

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
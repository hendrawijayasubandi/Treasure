package com.hendra.treasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MemberTreasure : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_treasure)

        supportActionBar?.title = "Member Treasure"

        recyclerView = findViewById(R.id.rv_members)
        recyclerView.setHasFixedSize(true)

        list.addAll(MembersData.listData)
        showRV()
    }

    private fun showRV() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = CardViewMemberAdapter(list)
        recyclerView.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallback(object : CardViewMemberAdapter.OnItemClickCallback {
            override fun onItemClicked(member: Member) {
                val moveIntentDetail = Intent(this@MemberTreasure, DetailActivity::class.java)
                moveIntentDetail.putExtra("Data", member)
                startActivity(moveIntentDetail)
                showSelectedMember(member)
            }
        })
    }

    private fun showSelectedMember(member: Member) {
        Toast.makeText(this, "Kamu Memilih "+member.name, Toast.LENGTH_SHORT).show()
    }
}
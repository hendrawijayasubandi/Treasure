package com.hendra.treasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "My Treasure"

        val btnAboutMe: Button = findViewById(R.id.btn_about_me)
        btnAboutMe.setOnClickListener(this)

        val btnMemberTreasure: Button = findViewById(R.id.btn_member_treasure)
        btnMemberTreasure.setOnClickListener(this)

        val btnMyTreasure: Button = findViewById(R.id.btn_my_treasure)
        btnMyTreasure.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about_me -> {
                val moveIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_member_treasure -> {
                val moveIntent = Intent(this@MainActivity, MemberTreasure::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_my_treasure -> {
                val moveIntent = Intent(this@MainActivity, FavoriteActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
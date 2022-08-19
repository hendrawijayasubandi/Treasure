package com.hendra.treasure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewMemberAdapter(private val listMember: ArrayList<Member>) : RecyclerView.Adapter<CardViewMemberAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnAddMyBias: Button = itemView.findViewById(R.id.btn_add_my_bias)

        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_member, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listMember[position])
        val member = listMember[position]
        Glide.with(holder.itemView.context)
            .load(member.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = member.name
        holder.tvDetail.text = member.detail
        holder.btnAddMyBias.setOnClickListener { Toast.makeText(holder.itemView.context, "Berhasil menambahkan " + listMember[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listMember[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }

        val (name, detail, facts, photo) = listMember[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDetail.text = detail
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listMember[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listMember.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(member: Member)
    }
}
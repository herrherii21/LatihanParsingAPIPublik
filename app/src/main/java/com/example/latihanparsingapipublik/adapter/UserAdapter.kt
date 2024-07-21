package com.example.latihanparsingapipublik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.latihanparsingapipublik.R
import com.example.latihanparsingapipublik.model.DataItem

class UserAdapter(private val users:MutableList<DataItem>)
    : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_users, parent, false)

        return ListViewHolder(view)
    }

    fun addUser(newUsers: DataItem){
        users.add(newUsers)
        notifyItemInserted(users.lastIndex)
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var user = users[position]

        holder.tvUsername.text = "${user.firstName} ${user.lastName}"
        holder.tvEmail.text = user.email

        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(88, 88).placeholder(R.drawable.icon_avatar))
            .transform(CircleCrop())
            .into(holder.ivAvatar)

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvUsername: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }


}
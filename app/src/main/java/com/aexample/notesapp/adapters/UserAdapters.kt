package com.aexample.notesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aexample.notesapp.R
import com.aexample.notesapp.model.UserModel

class UserAdapters(private val context: Context, private var userList:ArrayList<UserModel>, private val listener: Listener) : RecyclerView.Adapter<UserAdapters.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false))
    }

    override fun getItemCount(): Int =userList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val user=userList[position]
        holder.name.text=user.name
        holder.phone.text=user.phone.toString()
        holder.email.text=user.email
        holder.address.text=user.address
    }


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name: TextView =itemView.findViewById(R.id.tv_name)
        val email:TextView=itemView.findViewById(R.id.tv_email)
        val phone:TextView=itemView.findViewById(R.id.tv_phone)
        val address:TextView=itemView.findViewById(R.id.tv_address)

        init {
            itemView.setOnClickListener {
                listener.onClickListener(adapterPosition)
            }
        }
    }
    interface Listener{
        fun onClickListener(pos : Int)
    }
}
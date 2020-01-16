package com.illicitintelligence.myrealtimeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.illicitintelligence.myrealtimeapp.R
import com.illicitintelligence.myrealtimeapp.model.Message
import kotlinx.android.synthetic.main.message_layout.view.*

class RecyclerAdapter(private var messageList: List<Message>,
                      var context : Context) : RecyclerView.Adapter<RecyclerAdapter.MessageViewHolder>() {

    init {
        this.messageList = messageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MessageViewHolder {
        context = parent.context.applicationContext

        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.message_layout, parent, false)

        return MessageViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.userTextView.text = messageList[position].userName
        holder.dateTextView.text = messageList[position].messageDate
        holder.titleTextView.text = messageList[position].messageTitle
        holder.contentTextView.text = messageList[position].messageContent
    }

    class MessageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val userTextView: TextView = itemView.username_textview
        val dateTextView: TextView = itemView.date_textview
        val titleTextView: TextView = itemView.title_textview
        val contentTextView: TextView = itemView.content_textview
    }
}
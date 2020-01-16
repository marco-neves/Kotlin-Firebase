package com.illicitintelligence.myrealtimeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.illicitintelligence.myrealtimeapp.R
import com.illicitintelligence.myrealtimeapp.adapter.RecyclerAdapter
import com.illicitintelligence.myrealtimeapp.model.Message
import com.illicitintelligence.myrealtimeapp.viewmodel.RealViewModel
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RealViewModel
    private lateinit var messageObserver: Observer<Message>
    private var messageList: ArrayList<Message> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(RealViewModel::class.java)
        messageObserver =
                Observer { message ->
                    messageList.add(message)
                    addMessage(message)
                    setupRV(messageList)
                }

        viewModel.getLiveData().observe(this, messageObserver)
        val x = Message()
        x.messageContent = "Did you know the more you know the less you know you know?"
        x.messageDate = "01/15/2020"
        x.messageTitle = "My Message"
        x.userName = "Marco Neves"
        viewModel.sendRealMessage(x)
    }

    private fun addMessage(message: Message) {

        Log.d("TAG_X", "Message: " + message.messageContent)

    }

    private fun setupRV(response: List<Message>) {
        val adapter = RecyclerAdapter(response, this)
        val itemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)
        message_recyclerview.addItemDecoration(itemDecoration)
        message_recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        message_recyclerview.adapter = adapter
    }
}
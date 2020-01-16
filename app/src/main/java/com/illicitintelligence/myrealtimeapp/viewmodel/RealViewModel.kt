package com.illicitintelligence.myrealtimeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.illicitintelligence.myrealtimeapp.model.Message
import com.illicitintelligence.myrealtimeapp.util.Constants
import com.illicitintelligence.myrealtimeapp.util.Logger

class RealViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var messageRef: DatabaseReference
    // what we'll use to reference the firebase db
    private val liveData = MutableLiveData<Message>()
    init {
         messageRef = FirebaseDatabase.getInstance().
                getReference(Constants.DATABASE_PATH)

        // how to watch for value changes in the db
        messageRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (currentData in dataSnapshot.children) {
                    liveData.value = currentData.getValue(Message::class.java)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Logger.logError("Sumwrong here")
            }
        })
    }

    fun getLiveData(): MutableLiveData<Message> {
        return liveData
    }

    fun sendRealMessage(message: Message) {
        val childKey = messageRef.push().key
        if (childKey != null)
            messageRef.child(childKey).setValue(message)
    }
}

package com.themunsi.ui.contactlist

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import androidx.recyclerview.widget.RecyclerView
import com.themunsi.R

class AddContactList : AppCompatActivity() {
    lateinit var contactlist : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact_list)

        contactlist = findViewById(R.id.contact_list)

    }

}
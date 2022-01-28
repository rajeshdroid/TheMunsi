package com.themunsi.ui.contactlist

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build.ID
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.themunsi.R
import com.themunsi.model.ContactModel
import java.util.*


class AddContactList : AppCompatActivity() {
    lateinit var contactlist : RecyclerView
    var mobileContactList = ArrayList<ContactModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact_list)

        contactlist = findViewById(R.id.contact_list)

        if(ActivityCompat.checkSelfPermission(applicationContext, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            mobileContactList = getAllContactList()
        } else{
            requestPermissionss()
        }

    }

    private fun requestPermissionss() {

    }

    @SuppressLint("Range")
    private fun getAllContactList(): ArrayList<ContactModel> {
        var namelist = ArrayList<ContactModel>()
        val cr = contentResolver
        val cur: Cursor? = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null)

        if (cur!!.count > 0) {
            while (cur.moveToNext()) {
                val id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID))
                Log.e("TAG","ID:- "+id)
                val name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME))

                Log.e("TAG","Name:- "+name)
                val phonNumber = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)).toInt()

                if (phonNumber > 0) {
                    val cursorphone = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", arrayOf(id),null)
                    Log.e("TAG","PhoneNumberID:- "+id)
                    if (cursorphone!!.count > 0) {
                        while (cursorphone.moveToNext()) {
                            val phoneNumValue = cursorphone.getString(cursorphone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                                Log.e("TAG","PhoneNumber:- "+phoneNumValue)
                                namelist.add(ContactModel(id,name,phoneNumValue))
                        }
                    }
                }



            }
        }
        return namelist
    }

}
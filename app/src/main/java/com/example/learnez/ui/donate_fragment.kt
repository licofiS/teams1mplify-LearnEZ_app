package com.example.learnez.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.learnez.R

class donate_fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater!!.inflate(R.layout.donate_fragment,container,false)

        val contact_us_btn: Button = root.findViewById(R.id.contactus)

        contact_us_btn.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"7586972680"))
            startActivity(intent)
        }
        return root
    }
}
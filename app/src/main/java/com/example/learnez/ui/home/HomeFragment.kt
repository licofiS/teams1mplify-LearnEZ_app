package com.example.learnez.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.learnez.Learn
import com.example.learnez.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater!!.inflate(R.layout.fragment_home,container,false)


        //Spinner view of Stream
        val Stream_Spinner: Spinner = root.findViewById(R.id.Stream)


        // Intialising Stream array
        val StreamOptions = arrayListOf<String>("Select Here","Arts","Science","Commerce")

        //Creating adapter
        Stream_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,StreamOptions) }


        //Spinner view of Stream
        val Career_Spinner: Spinner = root.findViewById(R.id.Career)

        // Intialising Stream array
        val CareerOptions = arrayListOf<String>("Select Here","Army/AirForce/Navy", "Engineering",
            "Medical","IAS", "IPS","CA","Teacher")

        //Creating adapter
        Career_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,CareerOptions) }


        val learn: Button = root.findViewById(R.id.LearnMore)

        learn.setOnClickListener{
            val intent: Intent = Intent(activity, Learn::class.java)
            startActivity(intent)
        }
        return root
    }

}
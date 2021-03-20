package com.example.learnez.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.learnez.R

class learn_fragment : Fragment() {

    lateinit var Stream_Spinner: Spinner
    lateinit var Subject_Spinner: Spinner
    lateinit var Topics_Spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater!!.inflate(R.layout.learn_fragment,container,false)

        var GlobalSubject= arrayListOf<String>("null")

        //******************************************************************************************\\

        //Spinner view of Stream
        Stream_Spinner = root.findViewById(R.id.Stream)

        // Intialising Stream array
        val StreamOptions = arrayListOf<String>("Select Here","Arts","Science","Commerce")

        //Creating adapter
        Stream_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,StreamOptions) }


        //******************************************************************************************\\

        //Spinner view of Subject
        Subject_Spinner = root.findViewById(R.id.Subject)

        // Intialising Subject array
        val SubjectOptions = arrayListOf<String>("Select Here","Physics","Chemistry","Mathematics")

        //Creating adapter for Subject
        Subject_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,SubjectOptions) }



        //******************************************************************************************\\

        //Spinner view of Topics
        Topics_Spinner = root.findViewById(R.id.Topic)

        //Initialising Topics array
        val Physics = arrayListOf<String>("Select Here","Units,Dimensions and Measurement",
                "Motion in one dimension","Motion in two dimension","Newton's laws of motion",
                "Work,energy,power and collision","System of particles & Rotational motion",
                "Gravitation","Elasticity/Mechanical properties of solid",
                "Fluid Mechanics/Mechanical properties of fluid","Thermal properties of matter",
                "Kinetic theory of gases","Thermodynamics","Simple Harmonic Motion","Waves and sound")

        val Chemistry= arrayListOf<String>("Select Here","Electrochemistry","Solid State")

        val Mathematics = arrayListOf<String>("Select Here","Limits","Matrix",
                "Functions")

        //Ceating Adapter for Topics

        //Calling the subject Adapter to define a value
        Subject_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                var Subject = arrayListOf<String>("Topic")
                var bool=true

                val SUBJECT : String = SubjectOptions.get(position).toString()

                when(SUBJECT)
                {
                    "Physics" ->  Subject=  Physics

                    "Chemistry" ->  Subject=  Chemistry

                    "Mathematics" -> Subject=   Mathematics

                    else    ->   if(SUBJECT!="Select Here")
                    {bool = false}

                }
                if(bool==false){
                    val toast = Toast.makeText(activity,"Select Subject",Toast.LENGTH_SHORT)
                    toast.show()
                }
                else{
                    Topics_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,Subject) }
                    GlobalSubject = Subject
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
//******************************************************************************************\\


        Topics_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {

                var Topic_link = "Select Here"

                val Topic = GlobalSubject.get(position)

                Topic_link = when(Topic.toString())
                {
                    "Select Here" -> "Select Here"
                    "Units,Dimensions and Measurement" -> "https://youtu.be/ZgqH47_kBQE"
                    "Motion in one dimension" -> "https://youtu.be/iHoNjDlkuo4"
                    "Motion in two dimension" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsvZBXHBd9DcKPf9ydUJwKgj"
                    "Newton's laws of motion" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsujuRaecPxPpk-tv1mEvNBU"
                    "Work,energy,power and collision" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPst7xdBxZ2xu-Mk1kJXLA_vd"
                    "System of particles & Rotational motion" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsu4U2uiFrIuFgfkbYS22QCm"
                    "Gravitation" -> "https://www.youtube.com/playlist?list=PLF_7kfnwLFCEwyxzG-rg2uYeYA2q1S2d8"
                    "Elasticity/Mechanical properties of solid" -> "https://www.youtube.com/watch?v=4r_Rw6wMdjo&list=PLla1v6UBtno9LULmzkrdfc3M-J64cVaAZ"
                    "Fluid Mechanics/Mechanical properties of fluid" ->"https://www.youtube.com/playlist?list=PLF_7kfnwLFCHXd4k2jaPkHOBMzzGCq7t0"
                    "Thermal properties of matter" -> "https://www.youtube.com/playlist?list=PLF_7kfnwLFCFXX6N28304Ww_gUjh1Qtir"
                    "Kinetic theory of gases" -> "https://youtu.be/8fYhjU-yPhc"
                    "Thermodynamics" -> "https://www.youtube.com/playlist?list=PLF_7kfnwLFCFPfN4TGeJt1PQpJd3MG6Zz"
                    "Simple Harmonic Motion" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsvtPPERcgGcWmfI4vZg_jLM"
                    "Waves and sound" -> "https://www.youtube.com/playlist?list=PLF_7kfnwLFCEp1eygWPhgPI6A9th2Fw-S"
                    "Electrochemistry" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPssTn-R9X3BZCms9NKpUFUb0"
                    "Solid State" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsuJoldXfEROqx5oRXwQcaa5"
                    "Limits" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPstS3DTIyqkUecSW_7axdxKe"
                    "Matrix" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsvvReauHlV0an7GLbBce3xF"
                    "Functions" -> "https://www.youtube.com/playlist?list=PLbu_fGT0MPsulk5jpAkbkoyB5zh3g5Rzg"
                    else -> "Nothing"

                }
                if(Topic_link=="Nothing" || Topic_link=="Select Here" ){
                    Log.d("Not Selected","Not Selected spinner")
                }
                else if(Topic_link!="Select Here"){
                    val imgbtn : Button = root.findViewById(R.id.youtube)
                    imgbtn.setOnClickListener{
                        val youtube_intent = Intent(Intent.ACTION_VIEW, Uri.parse(Topic_link))
                        startActivity(youtube_intent)
                        val toast = Toast.makeText(activity,Topic,Toast.LENGTH_SHORT).show()

                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        return root
    }
}
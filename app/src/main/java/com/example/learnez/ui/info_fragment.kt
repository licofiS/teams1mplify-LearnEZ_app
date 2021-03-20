package com.example.learnez.ui

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learnez.R




class info_fragment : Fragment() {

    lateinit var Career_Spinner: Spinner
    lateinit var Interested_Spinner: Spinner
    lateinit var JobProfiles_Spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater!!.inflate(R.layout.info_fragment,container,false)

        var GlobalInterestG= arrayListOf<String>("null")
        var GlobalProfileG= arrayListOf<String>("null")

//******************************************************************************************\\

        // Career view from Spinner

        //Spinner View of Career
        Career_Spinner = root.findViewById(R.id.Career)

        val CareerOptions = arrayListOf<String>("Select Here","Defence", "Engineering",
                "Medical","IAS", "IPS","CA","Teacher")


        Career_Spinner.adapter= activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,CareerOptions) }


//******************************************************************************************\\

        //Interested view from Spinner

        //Spinner View of Interested/Branch
        Interested_Spinner= root.findViewById(R.id.Interested)


        val Engineering = arrayListOf<String>("Select Here","Computer Science", "Electronics","Mechanical","Civil")

        val Defence = arrayListOf<String>("Select Here", "Army", "Air Force","Navy","BSF")


        //Calling Career_spinner for selecting

        Career_Spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val careerList = CareerOptions.get(position).toString()
                var bool= true
                var GlobalInterest = arrayListOf<String>("Select Here")
                when(careerList)
                {
                    "Engineering" ->  GlobalInterest =  Engineering

                    "Defence" ->  GlobalInterest = Defence

                    else    ->   if(careerList!="Select Here")
                    {bool = false}

                }
                if(bool==false){
                    val toast = Toast.makeText(activity,"Select Career",Toast.LENGTH_SHORT)
                    toast.show()
                }
                else{
                    Interested_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,GlobalInterest) }
                    GlobalInterestG = GlobalInterest
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }


        /******************************************************************************************


        //Job Profile View

        var Computer = arrayListOf<String>("Select Here", "Software Developer","Network Engineer","Cyber Security","Data Analyst")

        var ECE= arrayListOf<String>("Select Here", "Embedded Systems","Internet of Things","Automation","Nano Electronics")

        val Median_salary: Button = root.findViewById(R.id.MedianSalary)
        Median_salary.text = "5.5 LPA - 10LPA average"

        val SCOPE: Button = root.findViewById(R.id.Scope)

        SCOPE.text = "Better/Good/Average"

        val FOREIGN_STUDIES: Button = root.findViewById(R.id.ForeignStudies)

        FOREIGN_STUDIES.text =




         ******************************************************************************************/
        JobProfiles_Spinner = root.findViewById(R.id.JobProfile)

        val Profile_list = arrayListOf<String>("Software Development","Network Engineer", "IoT","Embedded Systems")

        JobProfiles_Spinner.adapter = activity?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,Profile_list) }

//******************************************************************************************\\




        //******************************************************************************************\\

        // University List Creater

        val UnivList: ListView = root.findViewById(R.id.Univlsit)

        val engineeringlist = resources.getStringArray(R.array.EngineeringUniversity)

        UnivList.adapter = activity?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1,engineeringlist) }

//******************************************************************************************\\

        //Major Exams
        val examlist: ListView= root.findViewById(R.id.examlsit)

        val ExamList = resources.getStringArray(R.array.MajorExam)

        examlist.adapter = activity?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1,ExamList) }

//******************************************************************************************\\

        //Eligibility List

        val eligiblelist: ListView = root.findViewById(R.id.eligibility)

        val Eligibility = resources.getStringArray((R.array.eligible))

        eligiblelist.adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, Eligibility) }

//******************************************************************************************\\


        val shiksha: Button = root.findViewById(R.id.Shiksha)

        shiksha.setOnClickListener {

            val shiksha_intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shiksha.com/engineering/colleges/b-tech-colleges-india"))
            startActivity(shiksha_intent)
        }


        //******************************************************************************************\\
        return root
    }
}
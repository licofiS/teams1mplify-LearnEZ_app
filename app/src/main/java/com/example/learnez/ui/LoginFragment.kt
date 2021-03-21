package com.example.learnez.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learnez.R
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private val ref = FirebaseAuth.getInstance()
    lateinit var register: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater!!.inflate(R.layout.fragment_login,container,false)




        val email: EditText = root.findViewById(R.id.username)
        val password: EditText = root.findViewById(R.id.password)

        register = root.findViewById(R.id.login)



        register.setOnClickListener(View.OnClickListener () {

            ref.createUserWithEmailAndPassword(
                    email.text.toString().trim(),
                    password.text.toString().trim()
            )

            val toast = Toast.makeText(activity,"Registered succesfully", Toast.LENGTH_SHORT).show()

//            val intent: Intent = Intent(activity, Learn::class.java)
//            startActivity(intent)
        })

        return root
    }
}
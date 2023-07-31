package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.database.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    lateinit var binding : ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        binding.btnsumbit.setOnClickListener {


            val Fname = binding.edtFirstname.text.toString()
            val Lname = binding.edtLastname.text.toString()
            val Email = binding.edtEmail.text.toString()
            val Pass = binding.edtPassword.text.toString()
            val Number = binding.edtNumber.text.toString()
            val Age = binding.edtAge.text.toString()
            val City = binding.edtCity.text.toString()
            val State = binding.edtState.text.toString()

            if(Fname.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your First Name ", Toast.LENGTH_SHORT).show()
            }
            else if(Lname.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your last name ", Toast.LENGTH_SHORT).show()
            }
            else if (Email.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your Email Address ", Toast.LENGTH_SHORT).show()
            }

            else if (Pass.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your Password ", Toast.LENGTH_SHORT).show()
            }

            else if (Number.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your Number", Toast.LENGTH_SHORT).show()

            }

            else if (Age.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your Age ", Toast.LENGTH_SHORT).show()
            }

            else if (City.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your City ", Toast.LENGTH_SHORT).show()
            }

            else if (State.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your State ", Toast.LENGTH_SHORT).show()
            }


            else
            {

                if (Number.length != 10)
                {
                    Toast.makeText(this, "Please Enter Vaild Number", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "Your Account Create Succefully ", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, PrintActivity::class.java)
//                    intent.putExtra("Fname",Fname)
//                    intent.putExtra("Lname",Lname)
//                    intent.putExtra("Email",Email)
//                    intent.putExtra("Pass",Pass)
//                    intent.putExtra("Number",Number)
//                    intent.putExtra("Age",Age)
//                    intent.putExtra("City",City)
//                    intent.putExtra("State",State)
//                    startActivity(intent)


                    }

                var database = DataBaseHelper(this,"DatabaseForm.db",null,1)
                binding.btnsumbit.setOnClickListener {
                    database.insertData(Fname,Lname,Email,Pass,Number,Age,City,State)
                    database.update(4)
                    database.delete(10)
                    database.Display(Fname,Lname,Email,Pass,Number,Age,City,State)
                }

            }

        }
    }
}
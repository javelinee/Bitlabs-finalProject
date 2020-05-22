package com.project.application

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.project.application.activities.HomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "bitlabs"
    var sharedPref : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)

        btnSubmit.setOnClickListener{
            validateAll()
        }
    }

    private fun validateAll() {
        if (validateName() && validateEmail() && validatePassword() && validateGender()) {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

            val intent = Intent(this, HomeActivity::class.java)
            val editor = sharedPref!!.edit()

            editor.putString("userName", etName.text.toString())
            editor.putString("userEmail", etEmail.text.toString())
            editor.apply()

            startActivity(intent)
        }
    }

    fun validateName() : Boolean{
        if(etName.text.length == 0){
            tvError_name.setText("Name must be filled")
            return false
        } else {
            tvError_name.setText(null)
            return true
        }
    }

    fun validateEmail() : Boolean{
        if(etEmail.text.length == 0){
            tvError_email.setText("Email must be filled")
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.text).matches()){
            tvError_email.setText("Enter a required Email")
            return false
        } else {
            tvError_email.setText(null)
            return true
        }
    }

    fun validatePassword() : Boolean{
        if(etPassword.text.length == 0){
            tvError_password.setText("Password must be filled")
            return false
        } else if(etPassword.text.length < 8){
            tvError_password.setText("Password must be 8 characters or more")
            return false
        } else {
            tvError_password.setText(null)
            return true
        }
    }

    fun validateGender() : Boolean{
        if(genderRadio.checkedRadioButtonId == -1){
            tvError_gender.setText("Gender must be selected")
            return false
        } else {
            tvError_gender.setText(null)
            return true
        }
    }
}

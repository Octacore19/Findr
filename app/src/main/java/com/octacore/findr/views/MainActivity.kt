package com.octacore.findr.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.octacore.findr.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        find_button.setOnClickListener {
            val bin = textInputLayout.editText!!.text.toString()
            if (bin == ""){
                Toast.makeText(this, "TextField cannot be empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("data", bin)
            startActivity(intent)
        }
    }
}

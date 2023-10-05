package com.example.news

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.newslib.MainActivity2


class MainActivity : AppCompatActivity() {
    private val TARGET_ACTIVITY_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       findViewById<Button>(R.id.button).setOnClickListener {
           val intent = Intent(this@MainActivity, MainActivity2::class.java)
           startActivityForResult(intent, TARGET_ACTIVITY_REQUEST_CODE)
       }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TARGET_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this,"Welcome back!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
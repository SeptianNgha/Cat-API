package com.android.mycat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.android.mycat.R
import com.android.mycat.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {


    private var binding: ActivityUserBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val namaUser = findViewById<EditText>(R.id.et_text)
        val buttonUser = findViewById<Button>(R.id.btn_user)
        buttonUser.setOnClickListener {
            val namauser = namaUser.text.toString()
            val intent = Intent(this, CatsActivity::class.java)
            intent.putExtra("nama", namauser)
            startActivity(intent)
            finish()
        }

        val back = findViewById<ImageView>(R.id.iv_back)
        back.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }
    }
}
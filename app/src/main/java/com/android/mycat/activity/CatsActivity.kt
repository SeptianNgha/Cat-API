package com.android.mycat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mycat.R
import com.android.mycat.adapter.CatAdapter
import com.android.mycat.api.CatRequest
import com.android.mycat.api.CatResponse
import com.android.mycat.databinding.ActivityCatsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatsActivity : AppCompatActivity() {

    private val list = ArrayList<CatResponse>()

    private var binding: ActivityCatsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Menampilkan list cat
        showCat()

        // Memindahkan nama user
        getNamaUser()

        // Floating action button
        backToTop()
    }

    private fun backToTop() {

        binding?.fabButton?.setOnClickListener {
            binding?.root?.fullScroll(0)
        }
    }

    private fun getNamaUser() {
        val name = intent.getStringExtra("nama")
        val text = findViewById<TextView>(R.id.tv_title)
        text.text = name
    }

    private fun showCat() {
        binding?.rvPost?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding?.rvPost?.layoutManager = layoutManager
        CatRequest.instance.getCat().enqueue(object : Callback<ArrayList<CatResponse>> {
            override fun onResponse(
                call: Call<ArrayList<CatResponse>>,
                response: Response<ArrayList<CatResponse>>
            ) {
                val responseCode = response.code().toString()
                binding?.tvResponCode?.text = responseCode
                response.body()?.let { list.addAll(it) }

                fun catClicked(catResponse: CatResponse) {
                    Toast.makeText(this@CatsActivity, catResponse.name, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@CatsActivity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.nama, catResponse.name)
                    intent.putExtra(DetailActivity.desc, catResponse.description)
                    intent.putExtra(DetailActivity.image, catResponse.image.url)
                    intent.putExtra(DetailActivity.origin, catResponse.origin)
                    intent.putExtra(DetailActivity.temp, catResponse.temperament)
                    intent.putExtra(DetailActivity.life, catResponse.life_span)
                    intent.putExtra(DetailActivity.weight, catResponse.weight.imperial)

                    intent.putExtra(DetailActivity.adaptability, catResponse.adaptability)
                    intent.putExtra(DetailActivity.affection_level, catResponse.affection_level)
                    intent.putExtra(DetailActivity.child_friendly, catResponse.child_friendly)
                    intent.putExtra(DetailActivity.dog_friendly, catResponse.dog_friendly)
                    intent.putExtra(DetailActivity.energy_level, catResponse.energy_level)
                    intent.putExtra(DetailActivity.grooming, catResponse.grooming)

                    intent.putExtra(DetailActivity.health_issues, catResponse.health_issues)
                    intent.putExtra(DetailActivity.intelligence, catResponse.intelligence)
                    intent.putExtra(DetailActivity.shedding_level, catResponse.shedding_level)
                    intent.putExtra(DetailActivity.social_needs, catResponse.social_needs)
                    intent.putExtra(DetailActivity.stranger_friendly, catResponse.stranger_friendly)
                    intent.putExtra(DetailActivity.vocalisation, catResponse.vocalisation)

                    intent.putExtra(DetailActivity.wikipedia_url, catResponse.wikipedia_url)

                    startActivity(intent)
                }

                val adapter = CatAdapter(list, ::catClicked)
                binding?.rvPost?.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<CatResponse>>, t: Throwable) {
                Toast.makeText(this@CatsActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
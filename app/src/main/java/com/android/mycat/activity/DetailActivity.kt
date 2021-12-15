package com.android.mycat.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.android.mycat.api.CatResponse
import com.android.mycat.databinding.ActivityDetailBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    companion object {
        const val nama = "nama"
        const val desc = "desc"
        const val image = "image"
        const val origin = "origin"
        const val temp = "temp"
        const val weight = "weight"
        const val life = "life"

        const val adaptability = "adaptability"
        const val affection_level = "affection_level"
        const val child_friendly = "child_friendly"
        const val dog_friendly = "dog_friendly"
        const val energy_level = "energy_level"
        const val grooming = "grooming"

        const val health_issues = "health_issues"
        const val intelligence = "intelligence"
        const val shedding_level = "shedding_level"
        const val social_needs = "social_needs"
        const val stranger_friendly = "stranger_friendly"
        const val vocalisation = "vocalisation"

        const val wikipedia_url = "wikipedia_url"
    }

    private val list = ArrayList<CatResponse>()
    private var binding: ActivityDetailBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        pindahActivity()
        back()

    }

    private fun back() {
        binding?.ivBack?.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }
    }

    private fun pindahActivity() {
        val penerimaNama = intent.getStringExtra(nama)
        val teks = "$penerimaNama"
        binding?.tvName?.text = teks

        val penerimaDesc = intent.getStringExtra(desc)
        val desc = "$penerimaDesc"
        binding?.tvDescription?.text = desc

        val penerimaUrl = intent.getStringExtra(image)
        val image = "$penerimaUrl"
//        binding?.tvDescription?.text = image
        Picasso.get().load(image).into(binding?.ivImage)

        val penerimaOrigin = intent.getStringExtra(origin)
        val origin = "$penerimaOrigin"
        binding?.tvOrigin?.text = origin

        val penerimaTemp = intent.getStringExtra(temp)
        val temp = "$penerimaTemp"
        binding?.tvTemprament?.text = temp

        val penerimaBerat = intent.getStringExtra(weight)
        val weight = "$penerimaBerat"
        binding?.tvWeight?.text = weight

        val penerimaLife = intent.getStringExtra(life)
        val life = "$penerimaLife"
        binding?.tvLife?.text = life

        ////////////////////////////////////////////////////////////

        val penerimaAdap = intent.getStringExtra(adaptability)
        val adab = "$penerimaAdap"
        binding?.tvAdaptability?.text = adab

        val penerimaAffect = intent.getStringExtra(affection_level)
        val affect = "$penerimaAffect"
        binding?.tvAffectionLevel?.text = affect

        val penerimaChild = intent.getStringExtra(child_friendly)
        val child = "$penerimaChild"
        binding?.tvChildFriendly?.text = child

        val penerimaDog = intent.getStringExtra(dog_friendly)
        val dog = "$penerimaDog"
        binding?.tvDogFriendly?.text = dog

        val penerimaGroo = intent.getStringExtra(grooming)
        val groo = "$penerimaGroo"
        binding?.tvGrooming?.text = groo

        val penerimaEnergy = intent.getStringExtra(energy_level)
        val energy = "$penerimaEnergy"
        binding?.tvEnergyLevel?.text = energy




        val penerimaHlt = intent.getStringExtra(health_issues)
        val hlt = "$penerimaHlt"
        binding?.tvHealthIssues?.text = hlt

        val penerimaInt = intent.getStringExtra(intelligence)
        val intl = "$penerimaInt"
        binding?.tvIntelligence?.text = intl

        val penerimaShd = intent.getStringExtra(shedding_level)
        val shd = "$penerimaShd"
        binding?.tvSheddingLevel?.text = shd

        val penerimaSoc = intent.getStringExtra(social_needs)
        val soc = "$penerimaSoc"
        binding?.tvSocialNeeds?.text = soc

        val penerimaStr = intent.getStringExtra(stranger_friendly)
        val str = "$penerimaStr"
        binding?.tvStrangerFriendly?.text = str

        val penerimaVoc = intent.getStringExtra(vocalisation)
        val voc = "$penerimaVoc"
        binding?.tvVocalisation?.text = voc



        val penerimaWikped = intent.getStringExtra(wikipedia_url)
        val wikped = "$penerimaWikped"
        binding?.btnWikped?.setOnClickListener {
            val urlEncoded = Intent(Intent.ACTION_VIEW, Uri.parse(wikped))
            startActivity(urlEncoded)
        }
    }


}
package com.android.mycat.api

data class CatResponse (
    // Menambahkan data yang akan digunakan
    val id: String? = "",
    val name: String? = "",
    val description: String = "",
    val image: Gambar,
    val temperament: String = "",
    val origin: String = "",
    val life_span: String = "",
    val weight: Berat,

    val adaptability: String,
    val affection_level: String,
    val child_friendly: String,
    val dog_friendly: String,
    val energy_level: String,
    val grooming: String,

    val health_issues: String,
    val intelligence: String,
    val shedding_level: String,
    val social_needs: String,
    val stranger_friendly: String,
    val vocalisation: String,

    val wikipedia_url: String
)

data class Gambar (
    val url: String? = ""
)

data class Berat(
    val imperial: String = ""
)
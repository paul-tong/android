package com.tong.coderswag.services

import com.tong.coderswag.model.Category
import com.tong.coderswag.model.Product

object DataService {
    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES", "hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL", "digitalgoodsimage")
    )

    val hats = listOf(
        Product("beanie", "$12", "hat01"),
        Product("hat 2", "$13", "hat02"),
        Product("hat 3", "$14", "hat03"),
        Product("hat 4", "$15", "hat04")
        )

    val hoodies = listOf(
        Product("hoodie1", "21", "hoodie01"),
        Product("hoodie2", "22", "hoodie02"),
        Product("hoodie3", "23", "hoodie03"),
        Product("hoodie4", "24", "hoodie04")
    )

    val shirts = listOf(
        Product("shirt1", "31", "shirt01"),
        Product("shirt2", "32", "shirt02"),
        Product("shirt3", "33", "shirt03"),
        Product("shirt4", "34", "shirt04"),
        Product("shirt5", "35", "shirt05")
    )
}
package com.example.hellokitty.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_LOGIN = "login"
const val ROUT_REGISTER = "register"
const val ROUT_SPLASH = "splash"
const val ROUT_START = "start"
const val ROUT_PERSIAN = "persian"
const val ROUT_RAGDOLL = "ragdoll"
const val ROUT_RAGAMUFFIN = "ragamuffin"
const val ROUT_WIREHAIR = "wirehair"
const val ROUT_MAINECOON = "mainecoon"
const val ROUT_CARD = "card"
const val ROUT_MPESA = "mpesa"
const val ROUT_PAYMENT = "payment"
const val ROUT_CONTACT= "contact"
const val ROUT_DASHBOARD= "dashboard"


//Products

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"




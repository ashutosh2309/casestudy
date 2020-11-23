package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class MainModelList (@SerializedName("leagues") var leagues:ArrayList<MainModel>)
package com.example.adapter.endpoint.dto

import com.lucases.Hero

data class HeroDtoRequest(val name: String)

fun HeroDtoRequest.toBody() = Hero(name)
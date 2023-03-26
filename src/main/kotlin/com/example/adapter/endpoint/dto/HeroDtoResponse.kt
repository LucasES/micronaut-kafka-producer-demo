package com.example.adapter.endpoint.dto

import com.example.domain.Hero

data class HeroDtoResponse(val id:  Long? = null, val name: String, val power:Double) {
    companion object {
        fun fromHero(hero: Hero) = HeroDtoResponse(
            id = hero.id,
            name = hero.name,
            power = hero.power
        )
    }
}
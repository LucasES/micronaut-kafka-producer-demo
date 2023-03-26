package com.example.application.port.output

import com.lucases.Hero

interface HeroKafka {

    fun produce(hero: Hero)
}
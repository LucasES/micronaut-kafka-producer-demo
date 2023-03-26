package com.example.application.port.output

import com.example.domain.Hero

interface HeroRepository {

    fun findAll() : List<Hero>
}
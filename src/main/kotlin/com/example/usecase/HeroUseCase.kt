package com.example.usecase

import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse

interface HeroUseCase {

    fun produce(heroDto: HeroDtoRequest) : HeroDtoResponse
}
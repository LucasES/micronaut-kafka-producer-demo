package com.example.application.usecase

import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse
import com.example.adapter.endpoint.dto.ResultResponse

interface HeroUseCase {

    fun produce(heroDto: HeroDtoRequest) : ResultResponse

    fun findAll() : List<HeroDtoResponse>
}
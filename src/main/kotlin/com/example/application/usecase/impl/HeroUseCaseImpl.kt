package com.example.application.usecase.impl

import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse
import com.example.adapter.endpoint.dto.ResultResponse
import com.example.adapter.endpoint.dto.toBody
import com.example.application.port.output.HeroKafka
import com.example.application.port.output.HeroRepository
import com.example.application.usecase.HeroUseCase
import jakarta.inject.Singleton

@Singleton
class HeroUseCaseImpl(private val heroKafka: HeroKafka, private val heroRepository: HeroRepository) : HeroUseCase {

    override fun produce(heroDto: HeroDtoRequest): ResultResponse {
        return try {
            heroKafka.produce(heroDto.toBody())
            ResultResponse("Success")
        } catch (ex: Exception) {
            println("Error: " + ex.message)
            ResultResponse("Failed")
        }
    }

    override fun findAll(): List<HeroDtoResponse> {
        return heroRepository.findAll().map {
            HeroDtoResponse.fromHero(it)
        }
    }
}
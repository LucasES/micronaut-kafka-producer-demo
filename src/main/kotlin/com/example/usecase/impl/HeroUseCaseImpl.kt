package com.example.usecase.impl

import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse
import com.example.adapter.endpoint.dto.toBody
import com.example.adapter.messaging.client.HeroClient
import com.example.usecase.HeroUseCase
import jakarta.inject.Singleton

@Singleton
class HeroUseCaseImpl(private val heroClient: HeroClient) : HeroUseCase {

    override fun produce(heroDto: HeroDtoRequest): HeroDtoResponse {
        return try {
            heroClient.send(heroDto.toBody())
            HeroDtoResponse("Success")
        } catch (ex: Exception) {
            println("Error: " + ex.message)
            HeroDtoResponse("Failed")
        }
    }
}
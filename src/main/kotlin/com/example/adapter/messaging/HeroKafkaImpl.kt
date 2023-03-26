package com.example.adapter.messaging

import com.example.adapter.messaging.client.HeroClient
import com.example.application.port.output.HeroKafka
import com.lucases.Hero
import jakarta.inject.Singleton
import java.util.*

@Singleton
class HeroKafkaImpl(private val heroClient: HeroClient) : HeroKafka {
    override fun produce(hero: Hero) {
        try {
            heroClient.send(UUID.randomUUID(), hero)
        } catch (ex: Exception) {
            println("Error: " + ex.message)
            throw ex
        }
    }
}
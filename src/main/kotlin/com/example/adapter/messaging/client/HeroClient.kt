package com.example.adapter.messaging.client

import com.lucases.Hero
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import java.util.*

@KafkaClient
interface HeroClient {

    @Topic("hero-topic")
    fun send(@KafkaKey id: UUID, hero: Hero)
}
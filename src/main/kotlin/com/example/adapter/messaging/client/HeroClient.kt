package com.example.adapter.messaging.client

import com.lucases.Hero
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Body

@KafkaClient
interface HeroClient {

    @Topic("hero-topic")
    fun send(@Body hero: Hero?)
}
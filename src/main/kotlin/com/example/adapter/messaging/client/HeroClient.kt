package com.example.adapter.messaging.client

import com.lucases.Hero
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody


@KafkaClient
interface HeroClient {

    @Topic("hero-topic")
    fun send(@MessageBody hero: Hero?)
}
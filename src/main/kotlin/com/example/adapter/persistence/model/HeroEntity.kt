package com.example.adapter.persistence.model

import com.example.domain.Hero
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity("heroes")
data class HeroEntity(
    
    val name: String,

    val power: Double
) {
    @GeneratedValue
    @Id
    var id: Long? = null

    companion object {
        fun HeroEntity.toDomain() = Hero(this.id, this.name, this.power)
    }
}
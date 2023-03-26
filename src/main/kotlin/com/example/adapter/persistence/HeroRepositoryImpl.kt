package com.example.adapter.persistence

import com.example.adapter.persistence.model.HeroEntity.Companion.toDomain
import com.example.application.port.output.HeroRepository
import jakarta.inject.Singleton
import com.example.adapter.persistence.repository.HeroRepository as DBHeroRepository

@Singleton
class HeroRepositoryImpl(private val heroRepository: DBHeroRepository) : HeroRepository {

    override fun findAll() = heroRepository.findAll().map { it.toDomain() }

}
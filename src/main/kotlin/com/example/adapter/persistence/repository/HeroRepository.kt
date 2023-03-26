package com.example.adapter.persistence.repository

import com.example.adapter.persistence.model.HeroEntity
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.POSTGRES)
interface HeroRepository : CrudRepository<HeroEntity, Long>
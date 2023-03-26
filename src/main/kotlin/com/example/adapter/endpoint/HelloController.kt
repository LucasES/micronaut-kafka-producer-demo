package com.example.adapter.endpoint
import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse
import com.example.adapter.endpoint.dto.ResultResponse
import com.example.application.usecase.HeroUseCase
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/hero")
class HelloController(private val heroUseCase: HeroUseCase) {

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun sendHero(hero: HeroDtoRequest) : ResultResponse {
        return heroUseCase.produce(hero)
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll() = heroUseCase.findAll()
}
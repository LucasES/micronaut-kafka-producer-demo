package com.example.adapter.endpoint
import com.example.adapter.endpoint.dto.HeroDtoRequest
import com.example.adapter.endpoint.dto.HeroDtoResponse
import com.example.usecase.HeroUseCase
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces

@Controller("/hero")
class HelloController(private val heroUseCase: HeroUseCase) {

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun sendHero(hero: HeroDtoRequest) : HeroDtoResponse {
        return heroUseCase.produce(hero)
    }
}
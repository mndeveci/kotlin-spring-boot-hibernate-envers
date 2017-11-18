package com.mndeveci.spring.boot.rest

import com.mndeveci.spring.boot.rest.model.City
import com.mndeveci.spring.boot.rest.repository.CityRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class App {

    @Bean
    fun demo(cityRepository: CityRepository) : CommandLineRunner {
        return CommandLineRunner {
            cityRepository.save(
                    listOf(
                            City(34, "Istanbul"),
                            City(6, "Ankara"),
                            City(35, "Izmir")
                    )
            )
        }
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}
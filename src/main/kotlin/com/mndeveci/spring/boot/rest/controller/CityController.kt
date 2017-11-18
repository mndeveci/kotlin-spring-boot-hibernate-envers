package com.mndeveci.spring.boot.rest.controller

import com.mndeveci.spring.boot.rest.model.City
import com.mndeveci.spring.boot.rest.repository.CityRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cities")
class CityController(val cityRepository: CityRepository) {

    @GetMapping
    fun listAll() = cityRepository.findAll()

    @GetMapping("/{cityCode}")
    fun get(@PathVariable cityCode: Int) = cityRepository.findOne(cityCode)

    @PostMapping("/{cityCode}")
    fun save(@RequestBody city: City) = cityRepository.save(city)

    @PutMapping("/{cityCode}")
    fun update(@RequestBody city: City, @PathVariable cityCode: Int): City {
        val cityObject= cityRepository.findOne(cityCode)
        cityObject.name = city.name
        return cityRepository.save(cityObject)
    }

    @DeleteMapping("/{cityCode}")
    fun delete(@PathVariable cityCode: Int) = cityRepository.delete(cityCode)

}
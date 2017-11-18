package com.mndeveci.spring.boot.rest.controller

import com.mndeveci.spring.boot.rest.repository.CityRevisionRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cities/history")
class CityRevisionController(val cityRevisionRepository: CityRevisionRepository) {

    @GetMapping("/revisions/{cityCode}")
    fun getCityRevisions(@PathVariable cityCode: Int) = cityRevisionRepository.listCityRevisions(cityCode)

}
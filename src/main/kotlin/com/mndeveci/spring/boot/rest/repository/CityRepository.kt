package com.mndeveci.spring.boot.rest.repository

import com.mndeveci.spring.boot.rest.model.City
import org.springframework.data.repository.CrudRepository

interface CityRepository : CrudRepository<City, Int> {

    fun findByName(name: String) : List<City>

}
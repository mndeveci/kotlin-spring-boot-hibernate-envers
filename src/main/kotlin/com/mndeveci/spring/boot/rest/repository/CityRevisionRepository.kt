package com.mndeveci.spring.boot.rest.repository

import com.mndeveci.spring.boot.rest.model.City
import com.mndeveci.spring.boot.rest.model.EntityWithRevision
import com.mndeveci.spring.boot.rest.model.RevisionsEntity
import org.hibernate.envers.AuditReaderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
@Transactional
class CityRevisionRepository(
        @PersistenceContext
        var entityManager: EntityManager,

        @Autowired
        var cityRepository: CityRepository) {

    fun listCityRevisions(cityCode: Int): List<EntityWithRevision<City>> {
        val auditReader = AuditReaderFactory.get(entityManager)
        return auditReader.getRevisions(City::class.java, cityCode)
                .map {
                    val cityRevision = auditReader.find(City::class.java, cityCode, it)
                    val revisionDate = auditReader.getRevisionDate(it)

                    EntityWithRevision(RevisionsEntity(it.toLong(), revisionDate), cityRevision)
                }
    }

}
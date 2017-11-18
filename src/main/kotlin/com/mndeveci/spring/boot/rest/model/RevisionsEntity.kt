package com.mndeveci.spring.boot.rest.model

import com.mndeveci.spring.boot.rest.listener.EntityRevisionListener
import org.hibernate.envers.RevisionEntity
import org.hibernate.envers.RevisionNumber
import org.hibernate.envers.RevisionTimestamp
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@RevisionEntity(EntityRevisionListener::class)
data class RevisionsEntity(

        @Id
        @GeneratedValue
        @RevisionNumber
        var revisionId: Long = 0L,

        @RevisionTimestamp
        var revisionDate: Date? = null
)



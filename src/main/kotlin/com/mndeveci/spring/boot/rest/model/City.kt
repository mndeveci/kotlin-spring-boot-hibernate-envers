package com.mndeveci.spring.boot.rest.model

import org.hibernate.envers.Audited
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Audited
data class City(
        @Id
        var cityCode: Int = 0,

        var name: String = ""
)
package com.mndeveci.spring.boot.rest.model

data class EntityWithRevision<T>(

    var revision: RevisionsEntity,

    var entity: T
)
package com.mndeveci.spring.boot.rest.listener

import org.hibernate.envers.RevisionListener


class EntityRevisionListener: RevisionListener {

    override fun newRevision(revision: Any?) {
        println("New revision is created ${revision}")
    }
}
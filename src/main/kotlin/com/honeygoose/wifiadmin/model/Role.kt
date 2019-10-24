package com.honeygoose.wifiadmin.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "role")
class Role(
        @Column(name = "name")
        var name: String = "",

        @Id
        @SequenceGenerator(
                name = "role_id_generator",
                sequenceName = "role_id_seq",
                allocationSize = 1
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_generator")
        var id: Long = 0
)

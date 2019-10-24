package com.honeygoose.wifiadmin.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "\"user\"")
class User(
        @Column(name = "login")
        var login: String = "",

        @Column(name = "password")
        var password: String = "",

        @ManyToMany(cascade = [CascadeType.MERGE])
        @JoinTable(
                name = "user_roles",
                joinColumns = [JoinColumn(
                        name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(
                        name = "role_id", referencedColumnName = "id")])
        var roles: MutableList<Role> = mutableListOf(),

        @Id
        @SequenceGenerator(
                name = "user_id_generator",
                sequenceName = "user_id_seq",
                allocationSize = 1
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
        var id: Long = 0
)

package com.honeygoose.wifiadmin.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "report")
class ReportEntity (
        @Id
        @Column(name = "id")
        @SequenceGenerator(
                name = "report_id_generator",
                sequenceName = "report_id_seq",
                allocationSize = 1
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_generator")
        val id: Long? = null,

        @Column(name = "data", updatable = false)
        val data: String
//        ,

//        @Column(name = "created_time", updatable = false)
//        @CreatedDate
//        var createdTime: LocalDateTime? = null,
//
//        @Column(name = "modified_time")
//        @LastModifiedDate
//        var modifiedTime: LocalDateTime? = null
)
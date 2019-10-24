package com.honeygoose.wifiadmin.model

import com.honeygoose.wifiadmin.model.client.WiFiData
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "report")
@TypeDefs(
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
class ReportEntity(
        @Id
        @Column(name = "id")
        @SequenceGenerator(
                name = "report_id_generator",
                sequenceName = "report_id_seq",
                allocationSize = 1
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_generator")
        val id: Long? = null,

        @Type(type = "jsonb")
        @Column(name = "data", columnDefinition = "jsonb")
        val data: WiFiData
//        ,

//        @Column(name = "created_time", updatable = false)
//        @CreatedDate
//        var createdTime: LocalDateTime? = null,
//
//        @Column(name = "modified_time")
//        @LastModifiedDate
//        var modifiedTime: LocalDateTime? = null
)
package com.honeygoose.wifiadmin.repo

import com.honeygoose.wifiadmin.model.ReportEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : JpaRepository<ReportEntity, Long> {
    fun getById(id: Long): ReportEntity
}
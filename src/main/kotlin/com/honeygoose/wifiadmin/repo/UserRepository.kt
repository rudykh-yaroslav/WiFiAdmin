package com.honeygoose.wifiadmin.repo

import com.honeygoose.wifiadmin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    /**
     * Find user by login.
     * Login is unique so method must return only one user.
     */
    fun findByLogin(login: String): User
}

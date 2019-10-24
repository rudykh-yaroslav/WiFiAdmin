package com.honeygoose.wifiadmin.service

import com.honeygoose.wifiadmin.exception.ServiceException
import com.honeygoose.wifiadmin.model.RegistrationData
import com.honeygoose.wifiadmin.model.User
import com.honeygoose.wifiadmin.repo.RoleRepository
import com.honeygoose.wifiadmin.repo.UserRepository
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var userRepository: UserRepository, var roleRepository: RoleRepository) {
    fun login(login: String, password: String): String {
        try {
            val user = userRepository.findByLoginAndPassword(login, password)
            val token = UUID.randomUUID().toString()
            user.token = token
            userRepository.save(user)
            return token // user dto
        } catch (e: DataAccessException) {
            throw ServiceException() // e
        }
    }

    fun findByToken(token: String): User { // user dto
        try {
            val user = userRepository.findByToken(token)
            // map
            return user
        } catch (e: DataAccessException) {
            throw ServiceException()
        }
    }

    fun createUser(registrationData: RegistrationData): String {
        val user = User(registrationData.login, registrationData.password)
        try {
            userRepository.save(user)
            val role = roleRepository.findByName(registrationData.role)
            user.roles = mutableListOf(role)
            userRepository.save(user)
            return user.id.toString()
        } catch (e: DataAccessException) {
            throw ServiceException()
        }
    }
}

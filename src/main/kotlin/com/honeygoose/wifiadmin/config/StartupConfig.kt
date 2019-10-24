package com.honeygoose.wifiadmin.config

import com.honeygoose.wifiadmin.model.Role
import com.honeygoose.wifiadmin.model.User
import com.honeygoose.wifiadmin.repo.RoleRepository
import com.honeygoose.wifiadmin.repo.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StartupConfig {
    @Bean
    fun init(
            roleRepository: RoleRepository,
            userRepository: UserRepository
    ) = CommandLineRunner {
        val adminRole = Role(name = "admin")
        val techRole = Role(name = "technician")
        val userRole = Role(name = "user")
        roleRepository.save(adminRole)
        roleRepository.save(techRole)
        roleRepository.save(userRole)
        val someUser = User(login = "iAmUser", password = "123")
        someUser.roles = mutableListOf(userRole)
        userRepository.save(someUser)
        val someAdmin = User(login = "iAmAdmin", password = "456")
        someAdmin.roles = mutableListOf(adminRole)
        userRepository.save(someAdmin)
        val someTechnician = User(login = "iAmTechnician", password = "789")
        someTechnician.roles = mutableListOf(techRole)
        userRepository.save(someTechnician)
    }
}
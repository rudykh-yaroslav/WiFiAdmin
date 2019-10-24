package com.honeygoose.wifiadmin.config

import com.honeygoose.wifiadmin.model.Role
import com.honeygoose.wifiadmin.model.User
import com.honeygoose.wifiadmin.model.UserRole
import com.honeygoose.wifiadmin.repo.RoleRepository
import com.honeygoose.wifiadmin.repo.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class StartupConfig(
        var roleRepository: RoleRepository,
        var userRepository: UserRepository
) : CommandLineRunner {
    @Transactional
    override fun run(vararg args: String?) {
        userRepository.deleteAll()
        roleRepository.deleteAll()
        val adminRole = Role(name = UserRole.ADMIN.code)
        val techRole = Role(name = UserRole.TECHNICIAN.code)
        val userRole = Role(name = UserRole.USER.code)
        roleRepository.save(adminRole)
        roleRepository.save(techRole)
        roleRepository.save(userRole)
        val someAdmin = User(login = "someAdmin", password = "VeryStrong123")
        someAdmin.roles = mutableListOf(adminRole)
        userRepository.save(someAdmin)
    }
}

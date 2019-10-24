package com.honeygoose.wifiadmin.security

import com.honeygoose.wifiadmin.service.UserService
import org.springframework.dao.DataAccessException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class AuthenticationProvider : AbstractUserDetailsAuthenticationProvider() {
    lateinit var userService: UserService

    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {
        if (authentication == null || authentication.credentials == null
                || authentication.credentials !is String) {
            throw UsernameNotFoundException("")
        }
        try {
            val foundUser = userService.findByToken(authentication.credentials as String)
            val roleNames = foundUser.roles.map { it.name }.toTypedArray()
            val authorityList = AuthorityUtils.createAuthorityList(*roleNames)
            return User(foundUser.login, foundUser.password, true, true, true, true, authorityList)
        } catch (e: DataAccessException) {
            throw UsernameNotFoundException("", e)
        }
    }

    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: UsernamePasswordAuthenticationToken?) {
        // no-op
    }
}
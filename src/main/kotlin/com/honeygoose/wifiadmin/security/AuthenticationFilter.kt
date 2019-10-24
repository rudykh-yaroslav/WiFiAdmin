package com.honeygoose.wifiadmin.security

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.FilterChain

class AuthenticationFilter(requiresAuthenticationRequestMatcher: RequestMatcher?) : AbstractAuthenticationProcessingFilter(requiresAuthenticationRequestMatcher) {
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val authorization = request?.getHeader("AUTHORIZATION")
        val token = authorization?.removePrefix("Bearer")?.trim()
        val requestAuthentication = UsernamePasswordAuthenticationToken(token, token)
        return authenticationManager.authenticate(requestAuthentication)
    }

    // todo: this method and AuthenticationProvider.retrieveUser called twice
    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        SecurityContextHolder.getContext().authentication = authResult
        chain?.doFilter(request, response)
    }
}

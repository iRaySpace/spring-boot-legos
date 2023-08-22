package com.example.demo.auth

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails


class AuthToken(
  private val userDetails: UserDetails,
  val token: String
) : AbstractAuthenticationToken(userDetails.authorities) {
  override fun getCredentials() = token
  override fun getPrincipal() = userDetails
  override fun isAuthenticated(): Boolean = true
}
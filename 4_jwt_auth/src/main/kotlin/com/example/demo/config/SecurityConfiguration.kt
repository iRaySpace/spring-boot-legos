package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    @param:Value("\${jwt.secret}")
    val secret: String,
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(): UserDetailsService {
        var teacherUser = User.builder()
            .username("teacher")
            .password(passwordEncoder().encode("password"))
            .roles("TEACHER")
            .build()
        val studentUser = User.builder()
            .username("student")
            .password(passwordEncoder().encode("password"))
            .roles("STUDENT")
            .build()
        return InMemoryUserDetailsManager(teacherUser, studentUser)
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authConfig: AuthenticationConfiguration): AuthenticationManager {
        return authConfig.authenticationManager
    }

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors {}
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .apply(JWTAuthConfigurer(userDetailsService(), secret))
            // .addFilter(StatelessAuthenticationFilter(auth, secret))

        return http.build()
    }

    class JWTAuthConfigurer(
        val userDetailsService: UserDetailsService,
        val secret: String,
    ) : AbstractHttpConfigurer<JWTAuthConfigurer?, HttpSecurity?>() {
        override fun configure(builder: HttpSecurity?) {
            val authenticationManager = builder?.getSharedObject(AuthenticationManager::class.java)
            if (authenticationManager != null) {
                builder.addFilter(StatelessAuthenticationFilter(authenticationManager, userDetailsService, secret))
            }
        }
    }
}

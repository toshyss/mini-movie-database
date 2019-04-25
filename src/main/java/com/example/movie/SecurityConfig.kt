package com.example.movie


import com.example.movie.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
open class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/**/favicon.ico",
                "/image/**",
                "/assets/**",
                "/css/**",
                "/js/**"
        )
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/hello","/kotlin").permitAll()
//                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()

        http.formLogin()
                .loginProcessingUrl("/users/login")
                .loginPage("/index")
                .failureHandler(AuthenticationFailureHandler())
                .defaultSuccessUrl("/login/success")
                .usernameParameter("email").passwordParameter("password")
                .and()

        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout**"))
                .logoutSuccessUrl("/index")
    }

    @Configuration
    open class AuthenticationConfiguration : GlobalAuthenticationConfigurerAdapter() {
        @Autowired
        var userDetailsService : UserDetailsServiceImpl = UserDetailsServiceImpl()

        @Bean
        open fun passwordEncoder(): PasswordEncoder {
            return NoOpPasswordEncoder.getInstance()
        }

        override fun init(auth: AuthenticationManagerBuilder) {
            auth.userDetailsService(userDetailsService)
        }
    }
}
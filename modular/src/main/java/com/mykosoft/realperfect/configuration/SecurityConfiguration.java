package com.mykosoft.realperfect.configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/login", "/message", "/home")
				.permitAll()
				.anyRequest().authenticated()
				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// @formatter:on
	}
	
     @Override
     protected void configure(AuthenticationManagerBuilder auth)
             throws Exception {
         auth
             .inMemoryAuthentication()
                 .withUser("user")
                     .password("password")
                     .roles("USER")
                     .and()
                 .withUser("oleh")
                     .password("password")
                     .roles("USER");
     }

}
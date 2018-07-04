package com.example.demo.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationConfig authenticationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/student/findAll").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/student/{lastname}").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/student/{id}").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/student/*").hasRole("ADMIN")

                .antMatchers("/teacher/findALL").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/teacher/{lastname}").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/teacher/{id}").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/teacher/*").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/faculty/").hasAnyRole("TEACHER","STUDENT","GUEST")
                .antMatchers("/faculty/*").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/department/").hasAnyRole("TEACHER","STUDENT","GUEST")
                .antMatchers("/department/*").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/specialty/").hasAnyRole("TEACHER","STUDENT","GUEST")
                .antMatchers("/specialty/*").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/journal/").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/journal/*").hasAnyRole("TEACHER")

                .antMatchers(HttpMethod.GET,"/timetable/").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/timetable/*").hasAnyRole("TEACHER")

                .antMatchers(HttpMethod.GET,"/record/").hasAnyRole("TEACHER","STUDENT")
                .antMatchers("/record/*").hasAnyRole("TEACHER")

                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationConfig);
    }

    @Autowired
    public void userDetailsService(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN","TEACHER","STUDENT","GUEST");
        builder.inMemoryAuthentication().withUser("teacher")
                .password("{noop}teacher")
                .roles("TEACHER");
        builder.inMemoryAuthentication().withUser("student")
                .password("{noop}student")
                .roles("STUDENT");
        builder.inMemoryAuthentication().withUser("guest")
                .password("{noop}guest")
                .roles("GUEST");
    }
}
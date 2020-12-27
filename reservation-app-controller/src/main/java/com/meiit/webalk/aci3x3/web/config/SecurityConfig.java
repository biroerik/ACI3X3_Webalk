package com.meiit.webalk.aci3x3.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;
import com.meiit.webalk.aci3x3.services.userdetails.MyUserDetailService;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private BookingPersonRepository bookingPersonRepository;

    @Autowired
    MyUserDetailService myUserDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/registerPage").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/userDetails", true)
                .failureUrl("/accessdenied")
                .permitAll()
                .and().logout().logoutSuccessUrl("/login");

        http.csrf().disable();
    }

    @Bean
    @Override
    public MyUserDetailService userDetailsService() {
        return new MyUserDetailService();
    }

}

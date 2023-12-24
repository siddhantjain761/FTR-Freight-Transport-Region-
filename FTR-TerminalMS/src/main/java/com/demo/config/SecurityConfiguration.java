//package com.demo.config;
//
//import org.apache.tomcat.jni.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//@SuppressWarnings("deprecation")
//@EnableWebSecurity 
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true,proxyTargetClass=true)
//public class SecurityConfiguration{
// 
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
//				 
//	}
//
//    @Bean
//    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().httpBasic().and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and().csrf().disable();
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//	 
//}
//

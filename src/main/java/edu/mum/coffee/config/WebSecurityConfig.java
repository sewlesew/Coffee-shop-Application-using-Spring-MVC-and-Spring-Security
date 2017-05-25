package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserAuthenticationSuccessHandler successHandler;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                                .antMatchers("/secure/**").hasRole("USER")
                                .antMatchers("/products/**").permitAll()
                                .antMatchers("/persons/**").permitAll()
                                .antMatchers("/orders/**").permitAll()
                                
                                .antMatchers("/user").hasRole("USER")
                				.antMatchers("/admin").hasRole("ADMIN")
                                
				                .antMatchers("/", "/home", "/index").permitAll()                
				                .anyRequest().authenticated()
				                .and().csrf().disable().headers().frameOptions().disable().and() 			                
            .formLogin()
                 .successHandler(successHandler)
            	.permitAll()
            	.and()
            .logout()
            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            	.logoutSuccessUrl("/")
                .permitAll();
    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sewlesew@gmail.com").password("root").roles("ADMIN").and()
		.withUser("yaregal.sewlesew@gmail.com").password("root").roles("USER");
		
	}
}
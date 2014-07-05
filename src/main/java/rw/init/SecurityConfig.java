package rw.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Autowired
	private UserDetailsService customUserDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {    	
        http.authorizeRequests()
        	.antMatchers("/discounts/**").access("hasRole('ROLE_USER')")
        	.antMatchers("/user/**").access("hasRole('ROLE_USER')")
        	.antMatchers("/moder/**").access("hasRole('ROLE_MODERATOR')")
        	.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        http.formLogin()
        	.loginPage("/login")
        	.loginProcessingUrl("/j_spring_security_check")
        	.defaultSuccessUrl("/")
        	.failureUrl("/login?error=true")
        	.usernameParameter("j_username")
        	.passwordParameter("j_password")
        	.permitAll();
        http.logout()
        	.logoutUrl("/j_spring_security_logout")
        	.logoutSuccessUrl("/")
        	.invalidateHttpSession(true)
        	.permitAll();       
        http.exceptionHandling()
    		.accessDeniedPage("/403");
        http.csrf()
			.disable();
    }
 
}
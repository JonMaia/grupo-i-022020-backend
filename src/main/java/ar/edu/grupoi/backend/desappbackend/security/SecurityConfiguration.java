package ar.edu.grupoi.backend.desappbackend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.POST, "/crowdfunding/user/create").permitAll()
				.antMatchers(HttpMethod.POST, "/crowdfunding/user/login").permitAll()
				
				.antMatchers(HttpMethod.POST, "/backoffice/login").permitAll()
				.antMatchers("/crowdfunding/project/open_projects").permitAll()
				.antMatchers("/crowdfunding/project/next_finish").permitAll()
				.anyRequest().authenticated()
				.and().httpBasic();
	}

}

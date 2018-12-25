package com.jvzeller.templateapp.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticateFilter extends AbstractAuthenticationProcessingFilter {
	
	public JWTAuthenticateFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		Credentials credentials = new ObjectMapper().readValue(request.getInputStream(), Credentials.class);
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(credentials.getUser(), credentials.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication auth) throws IOException, ServletException {

		String json = new ObjectMapper().writeValueAsString(auth.getPrincipal());
		response.setContentType("application/json");
		response.getWriter().write(json);
		
		new TokenAuthenticationService().addAuthentication(response, auth);
	}


}

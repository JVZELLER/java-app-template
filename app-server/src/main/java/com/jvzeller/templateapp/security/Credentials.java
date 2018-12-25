package com.jvzeller.templateapp.security;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
	
	private String user;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private Stream<String> authorities;
	
	public Credentials() {
	}
	
	public Credentials(String user, Stream<String> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<SimpleGrantedAuthority> getAuthorities() {
		return this.authorities.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());		
	}

}

package com.jvzeller.templateapp.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenAuthenticationService {
	
	// EXPIRATION_TIME = 10 dias
		static final long EXPIRATION_TIME = 860_000_000;
		static final String SECRET = "MySecret";
		static final String TOKEN_PREFIX = "Bearer ";
		static final String HEADER_STRING = "Authorization";
		static final String EXPOSE_HEADER = "Access-Control-Expose-Headers";

		public void addAuthentication(HttpServletResponse response, Authentication auth) {

			List<String> authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
			
			String JWT = Jwts.builder()
					.setSubject(auth.getName())
					.claim("authorities", authorities)
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS512, SECRET)
					.compact();

			response.addHeader(HEADER_STRING, TOKEN_PREFIX.concat(JWT));
			response.addHeader(EXPOSE_HEADER, HEADER_STRING);

		}

		public Authentication getAuthentication(HttpServletRequest request) {

			String token = request.getHeader(HEADER_STRING);

			if (token != null) {
				
				Claims body = Jwts.parser()
						.setSigningKey(SECRET)
						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
						.getBody();
				
				if (body != null && body.containsKey("sub") && body.containsKey("authorities")) {				
					List<String> roles = (List<String>) body.get("authorities");				
					Credentials credentials = new Credentials(body.getSubject(), roles.stream());
					return new UsernamePasswordAuthenticationToken(credentials, null, credentials.getAuthorities());				
				}
			}


			return null;
		}

}

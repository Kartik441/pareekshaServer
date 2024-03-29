package com.pareeksha.pareekshaServer.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pareeksha.pareekshaServer.serviceImpl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username = null;
		String jwtToken = null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
			}catch(ExpiredJwtException e){
				e.printStackTrace();
				System.out.println("Jwt token expired");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR");
			}
			
		}else {
			System.out.println("Invalid Token, not start with bearer string");
		}
		
		// now validate the token
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails =this.userDetailsServiceImpl.loadUserByUsername(username);
			
			if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
				// token is valid
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
			}
		}else {
			System.out.println("Token not valid");
		}
			
			filterChain.doFilter(request, response);
		}
		
}



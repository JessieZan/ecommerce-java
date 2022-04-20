package com.com.jessiezan.ecommerce.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class EcommerceFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Logica de autenticação
		
		System.out.println("Requisicao passando pelo filtro");
		
		if(request.getHeader("Authorization") != null) {
			UsernamePasswordAuthenticationToken auth = TokenUtil.validate(request);
			
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		filterChain.doFilter(request,  response);
		
	}

}

package com.com.jessiezan.ecommerce.security;

import java.awt.RenderingHints.Key;
import java.util.Collection;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.com.jessiezan.ecommerce.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	
	private static final int SEGUNDOS = 1000;
	private static final int MINUTOS = 60*SEGUNDOS;
	private static final int HORAS = 60*MINUTOS;
	private static final int DIAS = 24*HORAS;
	
	
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";
	private static final long EXPIRATION = 2*MINUTOS;
	//private static final String SECRET_KEY = "12345678901234567890123456789012"; tamanho
	private static final String SECRET_KEY = "3c0MMerc3Do1f00dP@r@T3st3sD3JWT*";
	private static final String EMISSOR = "JessieZanSoftwareEngineer";
	  
	  
	public static String createToken(Usuario usuario) {
		SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		
		String token = Jwts.builder().setSubject(usuario.getUsername())
										 .setIssuer(EMISSOR)
										 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
										 .signWith(secretKey, SignatureAlgorithm.HS256)
										 .compact();
		System.out.println(token);
		return PREFIX + token;
	}
	
	private static boolean isExpirationDateValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));
	}
	
	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}
	
	private static boolean isSubjectValid(String username) {
		return username!=null && username.length()> 0;
	}
	
	public static UsernamePasswordAuthenticationToken validate(HttpServletRequest request) {
		
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, "");
		
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
				 					.build()
				 					.parseClaimsJws(token);
		
		String username = jwsClaims.getBody().getSubject();
		String issuer = jwsClaims.getBody().getIssuer();
		Date expiration = jwsClaims.getBody().getExpiration();
		
		if(isExpirationDateValid(expiration) && isEmissorValid(issuer) && isSubjectValid(username)) {
			return new UsernamePasswordAuthenticationToken(username, null, null);
		}
		
		return null;
	}
}

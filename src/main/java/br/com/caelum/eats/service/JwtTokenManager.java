package br.com.caelum.eats.service;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.caelum.eats.model.Role.ROLES;
import br.com.caelum.eats.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenManager {

	private SecretKey secret;
	private long expirationInMillis;

	public JwtTokenManager(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expirationInMillis) {
		this.secret = Keys.hmacShaKeyFor(secret.getBytes());
		this.expirationInMillis = expirationInMillis;
	}

	public String generateToken(User user) {
		final Date now = new Date();
		final Date expiration = new Date(now.getTime() + this.expirationInMillis);
		return Jwts.builder().setIssuer("Caelum Eats").setSubject(Long.toString(user.getId()))
				.claim("username", user.getName()).claim("roles", user.getRoles()).setIssuedAt(now)
				.setExpiration(expiration).signWith(this.secret, SignatureAlgorithm.HS256).compact();
	}

	public boolean isValid(String jwt) {
		try {
			Jwts.parser().setSigningKey(this.secret).build().parseClaimsJws(jwt);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public User getUserFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).build().parseClaimsJws(jwt).getBody();
		User user = new User();
		user.setName(claims.get("username", String.class));
		user.setId(Long.parseLong(claims.getSubject()));
		List<String> roles = claims.get("roles", List.class);
		roles.stream().forEach(role -> user.addRole(ROLES.valueOf(role)));
		return user;
	}

}

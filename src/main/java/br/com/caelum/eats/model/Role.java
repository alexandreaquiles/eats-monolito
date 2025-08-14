package br.com.caelum.eats.model;

import java.io.Serial;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role implements GrantedAuthority {

	@Serial private static final long serialVersionUID = 1L;

	public static enum ROLES {
		ADMIN, PARCEIRO;
		public String asAuthority() {
			return "ROLE_" + name();
		}
	}

	@Id
	private String authority;

	public String getRole() {
		return authority.replace("ROLE_", "");
	}
}

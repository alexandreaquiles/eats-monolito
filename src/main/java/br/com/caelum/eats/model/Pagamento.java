package br.com.caelum.eats.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagamento {

	public static enum Status {
		CRIADO,
		CONFIRMADO,
		CANCELADO;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull @Positive
	private BigDecimal valor;

	@NotBlank  @Size(max=100)
	private String nome;

	@NotBlank  @Size(max=19)
	private String numero;

	@NotBlank  @Size(max=7)
	private String expiracao;
	
	@NotBlank @Size(min=3, max=3)
	private String codigo;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(optional=false)
	private Pedido pedido;

	@ManyToOne(optional=false)
	private FormaDePagamento formaDePagamento;

}

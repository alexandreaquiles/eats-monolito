package br.com.caelum.eats.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestauranteFormaDePagamento {

	@EmbeddedId
	private RestauranteFormaDePagamentoId id;

	@ManyToOne
	@MapsId("restauranteId")
	private Restaurante restaurante;

	@ManyToOne
	@MapsId("formaDePagamentoId")
	private FormaDePagamento formaDePagamento;

	@Embeddable
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class RestauranteFormaDePagamentoId implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name = "restaurante_id")
		private Long restauranteId;

		@Column(name = "forma_de_pagamento_id")
		private Long formaDePagamentoId;
	}
}

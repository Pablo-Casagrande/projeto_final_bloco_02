package com.generation.farmacia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


	@Entity
	@Table(name = "tb_categorias")
	public class Categoria {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(length = 255)
		@NotBlank(message = "O atributo tipo do jogo é obrigatório")
		@Pattern(regexp = "^[^0-9].*", message = "O tipo do jogo não pode ser numérico")
		private String tipo;
		
		//relacionamento

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		//get e set para o relacionamento
	
}
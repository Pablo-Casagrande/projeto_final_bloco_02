package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
	
	@Entity
	@Table(name = "tb_produtos") // CREATE TABLE tb_postagens(); 
	public class Produto {

		@Id // Primary Key
		@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
		private Long id;
			
		@Column(length = 100)
		@NotBlank(message = "O nome é obrigatório!")
		@Size(min = 5, max = 100, message = "O nome deve ter no minimo 5 e no máximo 100 caracteres.")
		private String nome;
		
		@Column(precision = 10, scale = 2)
	    @NotNull(message = "Preço é obrigatório")
	    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
	    private BigDecimal preco;
		
		@Column(length = 1000)
		@Size(min = 1, max = 1000, message = "A descricao deve ter no minimo 1 e no máximo 1000 caracteres.")
		private String descricao;
		
		@ManyToOne
	    @JsonIgnoreProperties("produto")
	    private Categoria categoria;

	    @ManyToOne
	    @JsonIgnoreProperties("produto")
	    private Usuario usuario;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		
	

	}


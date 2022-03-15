package com.fuctura.cliente.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Table(name="TB_CLIENTE")
@Entity
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@NotBlank(message ="Não pode ser nulo ou vazio")
	private String nome;
	@Email
	private String email;
	private String telefone;
}

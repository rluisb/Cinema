package com.amarante.cinema.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.amarante.cinema.util.LocalDatePersistenceConverter;

@Entity
public class Sessao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sessao")
	private Integer id;
	@OneToOne
	private Sala sala;
	@OneToOne
	private Filme filme;
	@Column(nullable=false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate hora;
	
	public Sessao() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", sala=" + sala + ", filme=" + filme + ", hora=" + hora + "]";
	}
}

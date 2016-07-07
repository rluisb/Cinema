package com.amarante.cinema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sala")
	private Integer id;
	@Column(nullable=false)
	private Integer numero;
	@Column(nullable=false)
	private Integer poltronas;
	
	public Sala() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getPoltronas() {
		return poltronas;
	}

	public void setPoltronas(int poltronas) {
		this.poltronas = poltronas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numero;
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
		Sala other = (Sala) obj;
		if (id != other.id)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", numero=" + numero + ", poltronas=" + poltronas + "]";
	}

}

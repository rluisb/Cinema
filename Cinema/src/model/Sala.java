package model;

public class Sala {
	
	private int id;
	private int numero;
	private int poltronas;
	private Filme filme;
	
	public Sala(int numero, int poltronas, Filme filme) {
		this.id = -1;
		this.numero = numero;
		this.poltronas = poltronas;
		this.filme = filme;
	}
	
	public Sala(int id, int numero, int poltronas, Filme filme) {
		this.id = id;
		this.numero = numero;
		this.poltronas = poltronas;
		this.filme = filme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPoltronas() {
		return poltronas;
	}

	public void setPoltronas(int poltronas) {
		this.poltronas = poltronas;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
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
		return "Sala [id=" + id + ", numero=" + numero + ", poltronas=" + poltronas + ", filme=" + filme + "]";
	}
	
}

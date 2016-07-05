package model;

import java.util.Date;

public class Sessao {
	
	private int id;
	private int sala;
	private Date hora;
	private int filme;
	
	public Sessao(int sala, Date hora, int filme) {
		this.id = -1;
		this.sala = sala;
		this.hora = hora;
		this.filme = filme;
	}
	
	public Sessao(int id, int sala, Date hora, int filme) {
		this.id = id;
		this.sala = sala;
		this.hora = hora;
		this.filme = filme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public int getFilme() {
		return filme;
	}

	public void setFilme(int filme) {
		this.filme = filme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + filme;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + sala;
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
		if (filme != other.filme)
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (sala != other.sala)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", sala=" + sala + ", hora=" + hora + ", filme=" + filme + "]";
	}

	
	

}

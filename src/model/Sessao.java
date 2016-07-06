package model;

import java.util.Date;

public class Sessao {
	
	private int id;
	private Sala sala;
	private Date hora;
	
	public Sessao(Sala sala, Date hora) {
		this.id = -1;
		this.sala = sala;
		this.hora = hora;
	}
	
	public Sessao(int id, Sala sala, Date hora) {
		this.id = id;
		this.sala = sala;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sessao [id=" + id + ", sala=" + sala + ", hora=" + hora + "]";
	}
	
}

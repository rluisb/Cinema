package model;

public class VendaIngresso {
	
	private int id;
	private Sessao sessao;
	private Cliente cliente;
	
	public VendaIngresso(Sessao sessao, Cliente cliente) {
		this.id = -1;
		this.sessao = sessao;
		this.cliente = cliente;
	}
	
	public VendaIngresso(int id, Sessao sessao, Cliente cliente) {
		this.id = id;
		this.sessao = sessao;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		VendaIngresso other = (VendaIngresso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VendaIngresso [id=" + id + ", sessao=" + sessao + ", cliente=" + cliente + "]";
	}
	
}

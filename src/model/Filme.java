package model;

public class Filme {

	private int id;
	private String nome, sinopse, genero;
	
	public Filme(String nome, String sinopse, String genero) {
		this.id = -1;
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
	}
	
	public Filme(int id, String nome, String sinopse, String genero) {
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sinopse == null) ? 0 : sinopse.hashCode());
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
		Filme other = (Filme) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sinopse == null) {
			if (other.sinopse != null)
				return false;
		} else if (!sinopse.equals(other.sinopse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", sinopse=" + sinopse + ", genero=" + genero + "]";
	}
	
}

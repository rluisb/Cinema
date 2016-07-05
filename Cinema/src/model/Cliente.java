package model;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nome, rg, endereco, telefone;

    public Cliente(String nome, String rg, String endereco, String telefone) {
        this.id = -1;
        this.rg = rg;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Cliente(int id, String nome, String rg, String endereco, String telefone) {
        this.id = id;
        this.rg = rg;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.rg);
        return hash;
    }

    @Override
    public String toString() {
        return rg+" - "+nome + ", " + endereco + ", " + telefone;
    }
    
    
    
    
    
}

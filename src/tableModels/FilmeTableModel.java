package tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Filme;

public class FilmeTableModel extends AbstractTableModel{
	
	String cabecalho[];
    private List<Filme> filmes;
    
    public FilmeTableModel (String[]cab, List<Filme> temRazao) {
        this.filmes = temRazao;
        this.cabecalho = cab;
    }
    
    public FilmeTableModel (){
        cabecalho = new String[]{"ID", "Nome", "Sinopse", "Genero"};
        filmes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(filmes.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(filmes.get(rowIndex).getId());
        else if(columnIndex == 1)
            return(filmes.get(rowIndex).getNome());
        else if(columnIndex == 2)
            return(filmes.get(rowIndex).getSinopse());
        else
            return(filmes.get(rowIndex).getGenero());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addFilme(Filme c)
    {
        filmes.add(c);
    }

    public void removeFilme(int linha)
    {
        filmes.remove(linha);
    }

    public Filme getFilme(int linha)
    {
        return(filmes.get(linha));
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

}

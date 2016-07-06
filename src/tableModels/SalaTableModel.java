package tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Sala;

public class SalaTableModel extends AbstractTableModel{
	
	String cabecalho[];
    private List<Sala> Salas;
    
    public SalaTableModel (String[]cab, List<Sala> temRazao) {
        this.Salas = temRazao;
        this.cabecalho = cab;
    }
    
    public SalaTableModel (){
        cabecalho = new String[]{"ID", "Numero", "Poltronas", "Filme"};
        Salas = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(Salas.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(Salas.get(rowIndex).getId());
        else if(columnIndex == 1)
            return(Salas.get(rowIndex).getNumero());
        else if(columnIndex == 2)
            return(Salas.get(rowIndex).getPoltronas());
        else
            return(Salas.get(rowIndex).getFilme().getNome());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addSala(Sala c)
    {
        Salas.add(c);
    }

    public void removeSala(int linha)
    {
        Salas.remove(linha);
    }

    public Sala getSala(int linha)
    {
        return(Salas.get(linha));
    }

    public List<Sala> getSalas() {
        return Salas;
    }

    public void setSalas(List<Sala> Salas) {
        this.Salas = Salas;
    }

}

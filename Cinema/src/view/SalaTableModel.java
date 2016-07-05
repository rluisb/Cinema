package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.SalaDAO;
import model.Sala;


public class SalaTableModel extends AbstractTableModel{

    private String header[];
    private List<Sala> salas;
    private SalaDAO salaDao;

    public SalaTableModel()
    {
        this.header = new String[]{"Numero","Poltronas"};
        this.salas = new ArrayList<Sala>();
    }

    public SalaTableModel(String[] header, List<Sala> pessoas)
    {
        this.header = header;
        this.salas = salas;

    }

    @Override
    public int getRowCount() {
        return(this.salas.size());
    }

    @Override
    public int getColumnCount() {
        return(2);
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; 
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(this.salas.get(rowIndex).getNumero());
        else if(columnIndex == 1)
            return(this.salas.get(rowIndex).getPoltronas());
        else 
           return null;
    }

    public void setSalas(List<Sala> salas)
    {
        this.salas = salas;
    }

    public Sala getSala(int linha)
    {
       return(salas.get(linha));
    }
}

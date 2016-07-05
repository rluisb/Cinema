/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.SessaoDAO;
import model.Sessao;

public class SessaoTableModel extends AbstractTableModel{

    private String header[];
    private List<Sessao> sessaos;
    private SessaoDAO sessaoDao;

    public SessaoTableModel()
    {
        this.header = new String[]{"Sala","Filme","Hora"};
        this.sessaos = new ArrayList<Sessao>();
    }

    public SessaoTableModel(String[] header, List<Sessao> pessoas)
    {
        this.header = header;
        this.sessaos = sessaos;

    }

    @Override
    public int getRowCount() {
        return(this.sessaos.size());
    }

    @Override
    public int getColumnCount() {
        return(3);
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; 
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(this.sessaos.get(rowIndex).getSala());
        else if(columnIndex == 1)
            return(this.sessaos.get(rowIndex).getFilme());
        else if(columnIndex == 2)
            return(this.sessaos.get(rowIndex).getHora());
        else 
           return null;
    }

    public void setSessaos(List<Sessao> sessaos)
    {
        this.sessaos = sessaos;
    }

    public Sessao getSessao(int linha)
    {
       return(sessaos.get(linha));
    }
}

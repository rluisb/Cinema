package tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Sessao;

public class SessaoTableModel extends AbstractTableModel{
	
	String cabecalho[];
    private List<Sessao> Sessaos;
    
    public SessaoTableModel (String[]cab, List<Sessao> temRazao) {
        this.Sessaos = temRazao;
        this.cabecalho = cab;
    }
    
    public SessaoTableModel (){
        cabecalho = new String[]{"ID", "Sala", "Data", "Filme"};
        Sessaos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(Sessaos.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(Sessaos.get(rowIndex).getId());
        else if(columnIndex == 1)
            return(Sessaos.get(rowIndex).getSala().getNumero());
        else if(columnIndex == 2)
            return(Sessaos.get(rowIndex).getHora());
        else
            return(Sessaos.get(rowIndex).getSala().getFilme().getNome());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addSessao(Sessao c)
    {
        Sessaos.add(c);
    }

    public void removeSessao(int linha)
    {
        Sessaos.remove(linha);
    }

    public Sessao getSessao(int linha)
    {
        return(Sessaos.get(linha));
    }

    public List<Sessao> getSessaos() {
        return Sessaos;
    }

    public void setSessaos(List<Sessao> Sessaos) {
        this.Sessaos = Sessaos;
    }


}

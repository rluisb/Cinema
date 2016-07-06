package tableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.VendaIngresso;

public class VendaIngressoTableModel extends AbstractTableModel{
	
	String cabecalho[];
    private List<VendaIngresso> VendaIngressos;
    
    public VendaIngressoTableModel (String[]cab, List<VendaIngresso> temRazao) {
        this.VendaIngressos = temRazao;
        this.cabecalho = cab;
    }
    
    public VendaIngressoTableModel (){
    	cabecalho = new String[]{"ID", "Cliente", "Sala", "Data", "Filme"};
        VendaIngressos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(VendaIngressos.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(VendaIngressos.get(rowIndex).getId());
        else if(columnIndex == 1)
        	return(VendaIngressos.get(rowIndex).getCliente().getNome());
        else if(columnIndex == 2)
        	return(VendaIngressos.get(rowIndex).getSessao().getSala().getNumero());
        else if(columnIndex == 3)
            return(VendaIngressos.get(rowIndex).getSessao().getHora());
        else
            return(VendaIngressos.get(rowIndex).getSessao().getSala().getFilme().getNome());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addVendaIngresso(VendaIngresso c)
    {
        VendaIngressos.add(c);
    }

    public void removeVendaIngresso(int linha)
    {
        VendaIngressos.remove(linha);
    }

    public VendaIngresso getVendaIngresso(int linha)
    {
        return(VendaIngressos.get(linha));
    }

    public List<VendaIngresso> getVendaIngressos() {
        return VendaIngressos;
    }

    public void setVendaIngressos(List<VendaIngresso> VendaIngressos) {
        this.VendaIngressos = VendaIngressos;
    }

}

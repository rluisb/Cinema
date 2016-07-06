package tableModels;

import java.util.ArrayList;
import java.util.List;
import model.Voo;
import javax.swing.table.AbstractTableModel;
import util.DateUtil;

/**
 *
 * @author Thiago
 */
public class VooTableModel extends AbstractTableModel{
    String cabecalho[];
    private List<Voo> voos;
    
    public VooTableModel (String[]cab, List<Voo> v) {
        this.voos = v;
        this.cabecalho = cab;
    }
    
    public VooTableModel (){
        cabecalho = new String[]{"Código", "Hora - Data", "Origem", "Destino", "Avião"};
        voos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(voos.size());
    }

    @Override
    public int getColumnCount() {
        return (5);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(voos.get(rowIndex).getCodigo());
        else if(columnIndex == 1){            
            return(DateUtil.dateHourToString(voos.get(rowIndex).getHorarioDoVoo())).replace(" ", " - ");
        }
        else if(columnIndex == 2)
            return(voos.get(rowIndex).getOrigem().getNome());
        else if(columnIndex == 3)
            return(voos.get(rowIndex).getDestino().getNome());
        else
            return (voos.get(rowIndex).getAviao().getNome());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addVoo(Voo v)
    {
        voos.add(v);
    }

    public void removeVoo(int linha)
    {
        voos.remove(linha);
    }

    public Voo getVoo(int linha)
    {
        return(voos.get(linha));
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> v) {
        this.voos = v;
    }
    
}

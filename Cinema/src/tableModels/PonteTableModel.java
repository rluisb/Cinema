package tableModels;
import java.util.ArrayList;
import java.util.List;
import model.Ponte_Aerea;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago
 */
public class PonteTableModel extends AbstractTableModel{
    String cabecalho[];
    private List<Ponte_Aerea> pontes;
    
    public PonteTableModel (String[]cab, List<Ponte_Aerea> temRazao) {
        this.pontes = temRazao;
        this.cabecalho = cab;
    }
    
    public PonteTableModel (){
        cabecalho = new String[]{"ID", "Origem", "Destino"};
        pontes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(pontes.size());
    }

    @Override
    public int getColumnCount() {
        return (3);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(pontes.get(rowIndex).getId());
        else if(columnIndex == 1)
            return(pontes.get(rowIndex).getOrigem());
        else 
            return(pontes.get(rowIndex).getDestino());        
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addPonte_Aerea(Ponte_Aerea p)
    {
        pontes.add(p);
    }

    public void removePonte(int linha)
    {
        pontes.remove(linha);
    }

    public Ponte_Aerea getPonte(int linha)
    {
        return(pontes.get(linha));
    }

    public List<Ponte_Aerea> getPontes() {
        return pontes;
    }

    public void setPontes(List<Ponte_Aerea> clientes) {
        this.pontes = clientes;
    }
}

package tableModels;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aviao;

/**
 *
 * @author Thiago
 */
public class AviaoTableModel extends AbstractTableModel {
    
    String cabecalho[];
    private List<Aviao> avioes;
    
    public AviaoTableModel (String[]cab, List<Aviao> ovnis) {
        this.avioes = ovnis;
        this.cabecalho = cab;
    }
    public AviaoTableModel (){
        cabecalho = new String[]{"Código", "Nome"};
        avioes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(avioes.size());
    }

    @Override
    public int getColumnCount() {
        return(2);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(avioes.get(rowIndex).getCodigo());
        else 
            return(avioes.get(rowIndex).getNome());        
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addAviao(Aviao a)
    {
        avioes.add(a);
    }

    public void removeAviao(int linha)
    {
        avioes.remove(linha);
    }

    public Aviao getAviao(int linha)
    {
        return(avioes.get(linha));
    }

    public List<Aviao> getAvioes() {
        return avioes;
    }

    public void setAvioes(List<Aviao> avioes) {
        this.avioes = avioes;
    }
    
    
}

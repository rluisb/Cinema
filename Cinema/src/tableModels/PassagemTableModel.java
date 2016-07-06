package tableModels;
import util.DateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Passagem;

/**
 *
 * @author Thiago
 */
public class PassagemTableModel extends AbstractTableModel{
    String cabecalho[];
    private List<Passagem> passagens;
    
    public PassagemTableModel (String[]cab, List<Passagem> v) {
        this.passagens = v;
        this.cabecalho = cab;
    }
    
    public PassagemTableModel (){
        cabecalho = new String[]{"ID", "Cliente", "Voo", "Partida", "Origem", "Destino", "Venda"};
        passagens = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(passagens.size());
    }

    @Override
    public int getColumnCount() {
        return (7);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(passagens.get(rowIndex).getCodigo());
        else if(columnIndex == 1)
            return(passagens.get(rowIndex).getCliente().getNome());
        else if(columnIndex == 2)
            return(passagens.get(rowIndex).getVoo().getCodigo()); 
        else if(columnIndex == 3){
            String partida = DateUtil.dateHourToString((passagens.get(rowIndex)).getVoo().getHorarioDoVoo());
            return partida;            
        }
        else if(columnIndex == 4)
            return (passagens.get(rowIndex).getVoo().getOrigem());
        else if(columnIndex == 5)
            return (passagens.get(rowIndex).getVoo().getDestino());
        else{
            String hora = DateUtil.dateHourToString(passagens.get(rowIndex).getHoraVenda());
            return hora;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addPassagem(Passagem v)
    {
        passagens.add(v);
    }

    public void removePassagem(int linha)
    {
        passagens.remove(linha);
    }

    public Passagem getPassagem(int linha)
    {
        return(passagens.get(linha));
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> p) {
        this.passagens = p;
    }
    
}

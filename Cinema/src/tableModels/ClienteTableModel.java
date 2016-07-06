package tableModels;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago
 */
public class ClienteTableModel extends AbstractTableModel{
    String cabecalho[];
    private List<Cliente> clientes;
    
    public ClienteTableModel (String[]cab, List<Cliente> temRazao) {
        this.clientes = temRazao;
        this.cabecalho = cab;
    }
    
    public ClienteTableModel (){
        cabecalho = new String[]{"ID", "Nome", "RG", "Telefone"};
        clientes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return(clientes.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return(clientes.get(rowIndex).getId());
        else if(columnIndex == 1)
            return(clientes.get(rowIndex).getNome());
        else if(columnIndex == 2)
            return(clientes.get(rowIndex).getRG());
        else
            return(clientes.get(rowIndex).getTelefone());
    }
    
    @Override
    public String getColumnName(int column) {
        return cabecalho[column];
    }
    
    public void addCliente(Cliente c)
    {
        clientes.add(c);
    }

    public void removeCliente(int linha)
    {
        clientes.remove(linha);
    }

    public Cliente getCliente(int linha)
    {
        return(clientes.get(linha));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

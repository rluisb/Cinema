/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.ClienteDao;
import model.Cliente;

/**
 * @author lhries
 */
public class ClienteTableModel extends AbstractTableModel{

    private String header[];
    private List<Cliente> clientes;
    private ClienteDao clienteDao;

    public ClienteTableModel()
    {
        this.header = new String[]{"RG","Nome","Telefone"};
        this.clientes = new ArrayList<Cliente>();
        //this.clientes.add(new Cliente("Fulano", "102030", "Rua X", "23231199"));
    }

    public ClienteTableModel(String[] header, List<Cliente> pessoas)
    {
        this.header = header;
        this.clientes = clientes;

    }

    @Override
    public int getRowCount() {
        return(this.clientes.size());
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
            return(this.clientes.get(rowIndex).getRg());
        else if(columnIndex == 1)
            return(this.clientes.get(rowIndex).getNome());
        else if(columnIndex == 2)
            return(this.clientes.get(rowIndex).getTelefone());
        else 
           return null;
    }

    public void setClientes(List<Cliente> clientes)
    {
        this.clientes = clientes;
    }

    public Cliente getCliente(int linha)
    {
       return(clientes.get(linha));
    }
}

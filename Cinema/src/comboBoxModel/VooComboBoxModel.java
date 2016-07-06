/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comboBoxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Voo;

/**
 *
 * @author Thiago
 */
public class VooComboBoxModel extends AbstractListModel implements ComboBoxModel {
    private List<Voo> voos;
    private Voo selecionado = null;
    
    public VooComboBoxModel(List<Voo> v){
        this.voos = v;
    }
    
    public VooComboBoxModel(){
        this.voos = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return voos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return voos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selecionado = (Voo) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }
    
    public void setVoos(List<Voo> v) {
        this.voos = v;
    }    
}

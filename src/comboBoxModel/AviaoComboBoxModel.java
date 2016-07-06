package comboBoxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Aviao;

/**
 *
 * @author Thiago
 */
public class AviaoComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    private List<Aviao> avioes;
    private Aviao aviaoSelecionado = null;
    
    public AviaoComboBoxModel(List<Aviao> ovnis){
        this.avioes = ovnis;
    }
    
    public AviaoComboBoxModel(){
        avioes = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return avioes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return avioes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        aviaoSelecionado = (Aviao) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return aviaoSelecionado;
    }

    public void setAvioes(List<Aviao> avioes) {
        this.avioes = avioes;
    }
}

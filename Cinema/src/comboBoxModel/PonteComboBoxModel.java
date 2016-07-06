package comboBoxModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Ponte_Aerea;

/**
 *
 * @author Thiago
 */
public class PonteComboBoxModel extends AbstractListModel implements ComboBoxModel {
    private List<Ponte_Aerea> ponte_Aereas;
    private Ponte_Aerea ponteSelecionado = null;
    
    public PonteComboBoxModel(List<Ponte_Aerea> p){
        this.ponte_Aereas = p;
    }
    
    public PonteComboBoxModel(){
        ponte_Aereas = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return ponte_Aereas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ponte_Aereas.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        ponteSelecionado = (Ponte_Aerea) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return ponteSelecionado;
    }
    
    public void setPonte(List<Ponte_Aerea> pontes) {
        this.ponte_Aereas = pontes;
    }
}

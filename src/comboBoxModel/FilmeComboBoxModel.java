package comboBoxModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Filme;

public class FilmeComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    private List<Filme> filmes;
    private Filme filmeSelecionado = null;
    
    public FilmeComboBoxModel(List<Filme> ovnis){
        this.filmes = ovnis;
    }
    
    public FilmeComboBoxModel(){
        filmes = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return filmes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return filmes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        filmeSelecionado = (Filme) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return filmeSelecionado;
    }

    public void setAvioes(List<Filme> avioes) {
        this.filmes = avioes;
    }
}

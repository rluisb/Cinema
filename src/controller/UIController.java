package controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Thiago
 */
public class UIController {
    
    public static void centerJIF(JInternalFrame jif, JDesktopPane jdp) {
        Dimension desktopSize = jdp.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    
    public static void makeComboReadonly(JComboBox box) {
//        FormularioVoo painelFormulario = this.janela.getPainelFormulario();
        JComboBox boxMaquiado = box;        
        boxMaquiado.getEditor().getEditorComponent();
        Component editorComponent = boxMaquiado.getEditor().getEditorComponent();
        if (editorComponent instanceof JComboBox) {
            ((JComboBox) editorComponent).setEditable(false);
        }

        for (Component childComponent : boxMaquiado.getComponents()) {
            if (childComponent instanceof AbstractButton) {
                childComponent.setEnabled(false);
                final MouseListener[] listeners = childComponent.getListeners(MouseListener.class);
                for (MouseListener listener : listeners) {
                    childComponent.removeMouseListener(listener);
                }
            }
        }

        final MouseListener[] mouseListeners = boxMaquiado.getListeners(MouseListener.class);
        for (MouseListener listener : mouseListeners) {
            boxMaquiado.removeMouseListener(listener);
        }

        final KeyListener[] keyListeners = boxMaquiado.getListeners(KeyListener.class);
        for (KeyListener keyListener : keyListeners) {
            boxMaquiado.removeKeyListener(keyListener);
        }

        boxMaquiado.setFocusable(false);
        //box.getActionMap () clear ().; // nenhum efeito 
        //box.getInputMap () clear         
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import poo.cursosccm.entity.Tematicas;

/**
 *
 * @author ivan
 */
public class TematicasComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    private final List<Tematicas> tematicas;
    private Tematicas tematicaSeleccionada;
    private final static int FIRSTINDEX = 0;
    
    public TematicasComboBoxModel(){
        this.tematicas = new ArrayList<>();
    }
    
    public TematicasComboBoxModel(List<Tematicas> tematicas) {
        super();
        this.tematicas = tematicas;
        if (this.getSize() > 0) { 
            this.setSelectedItem(this.tematicas.get(FIRSTINDEX));
        }
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        tematicaSeleccionada = (Tematicas) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return tematicaSeleccionada;
    }

    @Override
    public int getSize() {
        return tematicas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return tematicas.get(index);
    }
    
    public Tematicas obtenerTematicaEn(int indice){
        return tematicas.get(indice);
    }

   
}





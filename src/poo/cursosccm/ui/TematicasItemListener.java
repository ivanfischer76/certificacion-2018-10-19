/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import poo.cursosccm.controller.GestorInscripcion;
import poo.cursosccm.entity.Tematicas;

/**
 *
 * @author ivan
 */
public class TematicasItemListener implements ItemListener{
    
    private final PantallaInscripcion pantallaInscripcion;
    private final GestorInscripcion gestor;
    private CursosTableModel cursosTableModel;

    public TematicasItemListener(PantallaInscripcion pantallaInscripcion, GestorInscripcion gestor) {
        this.gestor = gestor;
        this.pantallaInscripcion = pantallaInscripcion;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
         // obtenemos el la tematica seleccionado
        Tematicas tematicaSeleccionada = pantallaInscripcion.obtenerTematicaSeleccionada();
        //si el item no es nulo
        if (tematicaSeleccionada != null) {
            //rellenamos el modelo de la tabla
            cursosTableModel = new CursosTableModel(gestor.listarCursos(tematicaSeleccionada));
            //asignamos el modelo a la tabla
            pantallaInscripcion.setTableModel(cursosTableModel);
        }
        
    }
    
}

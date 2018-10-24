/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo.cursosccm.entity.Cursos;

/**
 *
 * @author ivan
 */
public class CursosTableModel extends AbstractTableModel{
    
    private static final String[] COLUMNAS = { "Nombre", "Profesor", "Aula", "Duración", "Carga Horaria", "Cupo" };
    
    private List<Cursos> cursos;

    public CursosTableModel() {
    }
    
    public CursosTableModel(List<Cursos> cursos) {
        super();
        this.cursos = cursos;
    }
    
    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Object retorno = null;
        Cursos curso = cursos.get(fila);
        switch (columna) {
            case 0:
                retorno = curso.getNombre();
                break;
            case 1:
                retorno = curso.getProfesor();
                break;
            case 2:
                retorno = curso.getAula();
                break;
            case 3:
                retorno = curso.getDuracion();
                break;
            case 4:
                retorno = curso.getCargaHoraria();
                break;
            case 5:
                retorno = curso.getCupo();
                break;
        }        
        return retorno;
    }
    
    @Override
    public String getColumnName(int index) {
        return COLUMNAS[index];
    }
    
    public Cursos obtenerCursoEn(int fila) {
        return cursos.get(fila);
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }
    
    public List<Cursos> getCursos(){
        return this.cursos;
    }
    
}

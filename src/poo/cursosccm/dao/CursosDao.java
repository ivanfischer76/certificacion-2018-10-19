/*
 * 
 */
package poo.cursosccm.dao;

import java.util.List;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Tematicas;

/**
 * Esta interface provee mecanismos para operar con entidades de tipo Cursos
 * @author Iván Fischer
 */
public interface CursosDao {
    
    /**
     * Devuelve una lista de cursos de la tematica provista
     * @param tematica
     * @return "List<Cursos>"
     */
    public List<Cursos> listarCursos(Tematicas tematica);
}

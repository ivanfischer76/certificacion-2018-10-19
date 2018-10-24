/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import java.util.List;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Tematicas;

/**
 *
 * @author ivan
 */
public interface CursosDao {
    
    /**
     * Devuelve una lista de cursos de la tematica provista
     * @param tematica
     * @return "List<Cursos>"
     */
    public List<Cursos> listarCursos(Tematicas tematica);
}

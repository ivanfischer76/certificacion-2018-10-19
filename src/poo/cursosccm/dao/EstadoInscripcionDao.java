/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import poo.cursosccm.entity.EstadoInscripcion;

/**
 * 
 * @author ivan
 */
public interface EstadoInscripcionDao {
    
    /**
     * Retorna el estado de la inscripcion correspondiente al id pasado por parámetro.
     * @param id
     * @return EstadoInscripcion: estadoInscripcion.
     * estado 1 = inscripto.
     * estado 2 = condicional.
     * estado 3 = no inscripto.
     */
    public EstadoInscripcion getEstadoById(int id);
}

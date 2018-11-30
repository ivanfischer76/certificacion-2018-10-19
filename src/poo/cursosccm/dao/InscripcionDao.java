/*
 * 
 */
package poo.cursosccm.dao;

import poo.cursosccm.entity.Inscripcion;

/**
 * Esta interface provee mecanismos para operar con entidades de tipo Inscripcion
 * @author Iván Fischer
 */
public interface InscripcionDao {
    
    /**
     * Guarda la inscripcion en la base de datos
     * @param inscripcion
     * @return int: un entero que representa el número de inscripción
     */
    public int guardar(Inscripcion inscripcion);
}

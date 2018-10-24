/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Inscripcion;
import poo.cursosccm.entity.Participantes;

/**
 *
 * @author ivan
 */
public interface InscripcionDao {
    
    /**
     * Devuelve un entero que representa la cantidad de cursos en los que 
     * el participante, pasado como parámetro, está inscripto.
     * @param participante
     * @return int: que representa la cantidad de cursos en los que el participante está inscripto
     */
    public int getCantidadCursosPorParticipante(Participantes participante);
    
    /**
     * Devuelve un booleano que indica si el participante pasado como parámetro
     * se encuentra inscripto en ese curso. 
     * Esto sirve para evitar que un participante se inscriba dos veces en el
     * mismo curso.
     * @param participante
     * @param curso
     * @return  true: si el participante se encuentra inscripto en ese curso
     *          false: en caso contrario
     */
    public boolean estaInscripto(Participantes participante, Cursos curso);
    
    /**
     * Devuelve un booleano que indica si quedan vacantes en el cupo 
     * del curso pasado como parámetro.
     * @param curso
     * @return  true: si hay cupos disponibles
     *          false: en caso contrario
     */
    public boolean hayVacantes(Cursos curso);
    
    /**
     * Guarda la inscripcion en la base de datos
     * @param inscripcion
     * @return int: un entero que representa el número de inscripción
     */
    public int guardar(Inscripcion inscripcion);
}

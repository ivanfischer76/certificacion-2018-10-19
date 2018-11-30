/*
 * 
 */
package poo.cursosccm.dao;

import poo.cursosccm.entity.Participantes;

/**
 * Esta interface provee mecanismos para operar con entidades de tipo Participantes
 * @author Iván Fischer
 */
public interface ParticipantesDao {

    /**
     * Decuelve una única instancia de Participantes que coincide
     * con el campo email que recibe como parámetro.
     * @param email
     * @return Participantes
     */
    public Participantes buscarParticipanteXemail(String email);
}

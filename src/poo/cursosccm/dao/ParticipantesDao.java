/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import poo.cursosccm.entity.Participantes;

/**
 *
 * @author ivan
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

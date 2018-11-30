/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import org.hibernate.SessionFactory;
import poo.cursosccm.entity.EstadoInscripcion;

/**
 *
 * @author ivan
 */
public class EstadoInscripcionHibernateImpl implements EstadoInscripcionDao{
    
    private final SessionFactory sessionFactory;

    public EstadoInscripcionHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public EstadoInscripcion getEstadoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

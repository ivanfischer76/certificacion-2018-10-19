/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Inscripcion;
import poo.cursosccm.entity.Participantes;

/**
 *
 * @author ivan
 */
public class InscripcionDaoHibernateImpl implements InscripcionDao{
    
    private final SessionFactory sessionFactory;

    public InscripcionDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int getCantidadCursosPorParticipante(Participantes participante) {
        int cantidad;
        try (Session session = sessionFactory.openSession()) {
            String consulta = "select count(cursos) as cantidad from Inscripcion i where i.participantes = :p";
            Query query = session.createQuery(consulta);
            query.setParameter("p", participante);
            cantidad = Integer.parseInt(query.getSingleResult().toString());
        }
        return cantidad;
    }

    @Override
    public boolean estaInscripto(Participantes participante, Cursos curso) {
        int cantidad;
        try (Session session = sessionFactory.openSession()) {
            String consulta = "select count(i.idinscripcion) as cantidad  from Inscripcion i where i.participantes = :p and i.cursos = :c";
            Query query = session.createQuery(consulta);
            query.setParameter("p", participante);   
            query.setParameter("c", curso);
            cantidad = Integer.parseInt(query.getSingleResult().toString()); 
        }
        if(cantidad==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean hayVacantes(Cursos curso) {
        int cantidad;
        try (Session session = sessionFactory.openSession()) {
            String consulta = "select count(i.idinscripcion) as cantidad  from Inscripcion i where i.cursos = :c";
            Query query = session.createQuery(consulta);
            query.setParameter("c", curso);
            cantidad = Integer.parseInt(query.getSingleResult().toString()); 
        }
        return cantidad<curso.getCupo();        
    }
    
    @Override
    public int guardar(Inscripcion inscripcion) {
        Integer id;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            id = (Integer) session.save(inscripcion);
            session.getTransaction().commit();
        }
        return id;
    }
    
}
